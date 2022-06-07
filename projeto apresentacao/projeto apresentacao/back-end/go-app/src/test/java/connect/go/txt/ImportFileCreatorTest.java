package connect.go.txt;

import connect.go.models.dto.UserRegistration;
import connect.go.models.dto.UserResponse;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ImportFileCreatorTest {

    @Test
    void criarImportFile() {
        List<UserRegistration> userRegistrations = new ArrayList<>();
        userRegistrations.add(new UserRegistration("Mauricio Ishikawa", "mauricio@goapp.com.br", "mauricio123",
                "usuario", "M", LocalDate.of(1994, 12, 2), "SP", "São Paulo", "Cerqueira César"));
        userRegistrations.add(new UserRegistration("Tais Fermino", "tais@goapp.com.br", "tais123",
                "usuario", "F", LocalDate.of(2001, 8, 13), "SP", "São Paulo", "Cerqueira César"));
        userRegistrations.add(new UserRegistration("Rafaella Kimberlly", "rafaela@goapp.com.br", "rafaela123",
                "usuario", "F", LocalDate.of(2000, 10, 28), "SP", "São Paulo", "Cerqueira César"));
        userRegistrations.add(new UserRegistration("Christian Hamai", "christian@goapp.com.br", "mauricio123",
                "usuario", "M", LocalDate.of(2003, 07, 20), "SP", "São Paulo", "Cerqueira César"));
        gravaArquivoTxt("cadastro1.txt", userRegistrations);

        List<UserRegistration> userRegistrations2 = new ArrayList<>();
        userRegistrations2.add(new UserRegistration("Pedro Aragão", "pedro@goapp.com.br", "pedro123",
                "usuario", "M", LocalDate.of(1994, 12, 2), "SP", "São Paulo", "Cerqueira César"));
        userRegistrations2.add(new UserRegistration("Jorge Leão", "jorge@goapp.com.br", "jorge123",
                "usuario", "M", LocalDate.of(2001, 8, 13), "SP", "São Paulo", "Cerqueira César"));
        gravaArquivoTxt("cadastro2.txt", userRegistrations2);
    }
    public void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " + erro);
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro na gravação do arquivo: " + erro);
        }
    }

    public void gravaArquivoTxt(String nomeArq, List<UserRegistration> userRegistrations) {
        int contaRegistroCorpo = 0;
        UserResponse userResponse;

        // Monta o registro de header
        String header = "00Cadastro";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de corpo (ou de detalhe)
        String corpo;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (UserRegistration userRegistration : userRegistrations) {
            corpo = "02";
            corpo += String.format("%-45.45s", userRegistration.getName());
            corpo += String.format("%-45.45s", userRegistration.getEmail());
            corpo += String.format("%-15.15s", userRegistration.getPassword());
            corpo += String.format("%-15.15s", userRegistration.getRole());
            corpo += String.format("%-15.15s", userRegistration.getGenre());
            corpo += String.format("%-10.10s", userRegistration.getBirthDate().format(formatter));
            gravaRegistro(corpo, nomeArq);
            corpo = "03";
            corpo += String.format("%-2.2s", userRegistration.getState());
            corpo += String.format("%-45.45s", userRegistration.getCity());
            corpo += String.format("%-45.45s", userRegistration.getDistrict());
            gravaRegistro(corpo, nomeArq);
            contaRegistroCorpo++;
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegistroCorpo);
        gravaRegistro(trailer, nomeArq);
    }
}
