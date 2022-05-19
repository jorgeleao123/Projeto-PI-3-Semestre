package connect.go.usecases;

import connect.go.controllers.UserController;
import connect.go.models.dto.AddressTxtDTO;
import connect.go.models.dto.UserRegistration;
import connect.go.models.dto.UserResponse;
import connect.go.models.dto.UserTxtDTO;
import connect.go.utils.FilaObj;
import connect.go.utils.PilhaObj;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class TxtService {

    private final UserController controller;
    PilhaObj<UserResponse> userResponses;
    FilaObj<UserRegistration> userRegistrations;

    public void leArquivoTxtUserRegistration(MultipartFile file) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, email, senha, cargo, genero, dataNascimento;
        String estado, cidade, bairro;

        int contaRegDadoLido = 0;
        int qtdRegDadoGravado;

        List<UserTxtDTO> listaUser = new ArrayList<>();
        List<AddressTxtDTO> listaAddress = new ArrayList<>();

        // Abre o arquivo para leitura
        try {
            InputStream is = file.getInputStream();
            entrada = new BufferedReader(new InputStreamReader(is));
//            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " + erro);
        }

        // Leitura do arquivo
        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    // Exibe as informações do registro de header
                    System.out.println("Tipo do arquivo: " +
                            registro.substring(2, 10));
                    System.out.println("Data e hora de gravação: " +
                            registro.substring(10, 29));
                    System.out.println("Versão do documento de layout: " +
                            registro.substring(29, 31));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegDadoGravado = Integer.parseInt(registro.substring(2, 7));
                    if (contaRegDadoLido == qtdRegDadoGravado) {
                        System.out.println("Quantidade de registros lidos compatível " +
                                "com a quantidade de registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos incompatível " +
                                "com a quantidade de registros gravados");
                    }

                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de corpo de usuário");
                    // trim() elimina os brancos à direita da String
                    nome = registro.substring(2, 47).trim();
                    email = registro.substring(47, 92).trim();
                    senha = registro.substring(92, 107).trim();
                    cargo = registro.substring(107, 122).trim();
                    genero = registro.substring(122, 137).trim();
                    dataNascimento = registro.substring(137, 147).trim();
                    contaRegDadoLido++;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate date = LocalDate.parse(dataNascimento, formatter);
                    listaUser.add(new UserTxtDTO(nome, email, senha, cargo, genero, date));
                } else if (tipoRegistro.equals("03")) {
                    System.out.println("É um registro de corpo de endereço");
                    // trim() elimina os brancos à direita da String
                    estado = registro.substring(2, 4).trim();
                    cidade = registro.substring(4, 49).trim();
                    bairro = registro.substring(49, 94).trim();
                    listaAddress.add(new AddressTxtDTO(estado, cidade, bairro));
                } else {
                    System.out.println("Tipo de registro inválido");
                }
                // Le o proximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo: " + erro);
        }

        userRegistrations = new FilaObj<>(contaRegDadoLido);
        userResponses = new PilhaObj<>(contaRegDadoLido);
        for (int i = 0; i < listaUser.size(); i++) {
            userRegistrations.insert(new UserRegistration(listaUser.get(i), listaAddress.get(i)));
        }



    }

    public void cadastraUsuariosFila() {
        while (!userRegistrations.isEmpty()) {
            ResponseEntity<UserResponse> response = controller.createUser(userRegistrations.poll());
            if (response.getStatusCode().is2xxSuccessful()) {
                userResponses.push(response.getBody());
            }
        }
    }

    public void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq,true));
        }
        catch(IOException erro) {
            System.out.println("Erro na abertura do arquivo: " + erro);
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch(IOException erro) {
            System.out.println("Erro na gravação do arquivo: " + erro);
        }
    }

    public void gravaArquivoTxt(String nomeArq) {
        int contaRegistroCorpo = 0;
        UserResponse userResponse;

        // Monta o registro de header
        String header = "00Usuarios";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de corpo (ou de detalhe)
        String corpo;
        while (!userResponses.isEmpty()) {
            userResponse = userResponses.pop();
            corpo = "02";
            corpo += String.format("%08d", userResponse.getId());
            corpo += String.format("%-45.45s", userResponse.getName());
            corpo += String.format("%-45.45s", userResponse.getEmail());
            corpo += String.format("%-15.15s", userResponse.getRole());
            corpo += String.format("%-15.15s", userResponse.getGenre());
            corpo += String.format("%-7.7s", userResponse.getColorProfile());
            corpo += String.format("%-7.7s", userResponse.getColorMenu());
            corpo += String.format("%-15.15s", userResponse.getStatus());
            corpo += String.format("%04d", userResponse.getPostCounter());
            corpo += String.format("%-10.10s", userResponse.getBirthDate());
            gravaRegistro(corpo, nomeArq);
            contaRegistroCorpo++;
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegistroCorpo);
        gravaRegistro(trailer, nomeArq);
    }

    public String leExportaTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, resposta;

        // Abre o arquivo para leitura
        try {
//            InputStream is = file.getInputStream();
//            entrada = new BufferedReader(new InputStreamReader(is));
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " + erro);
        }
        resposta = "";
        try {
            registro = entrada.readLine();

            while (registro != null) {
                resposta += registro + "\n";

                // Le o proximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo: " + erro);
        }
        limparRegistro(nomeArq);
        return resposta;
    }

    public void limparRegistro(String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq,false));
        }
        catch(IOException erro) {
            System.out.println("Erro na abertura do arquivo: " + erro);
        }

        try {
            saida.append("");
            saida.close();
        }
        catch(IOException erro) {
            System.out.println("Erro na gravação do arquivo: " + erro);
        }
    }
}
