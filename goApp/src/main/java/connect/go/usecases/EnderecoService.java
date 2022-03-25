package connect.go.usecases;

import connect.go.Repositories.EnderecoRepository;
import connect.go.models.Endereco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public Endereco cadastrar(Endereco endereco) {
        if (isEnderecoExists(endereco)){
            return enderecoRepository.findAllByCep(endereco.getCep()).get(0);
        }
        return enderecoRepository.save(endereco);
    }

    private boolean isEnderecoExists(Endereco endereco) {
        return enderecoRepository.existsByCep(endereco.getCep());
    }
}
