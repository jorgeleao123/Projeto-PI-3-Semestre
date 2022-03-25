package connect.go.usecases;

import connect.go.Repositories.EnderecoFavoritoRepository;
import connect.go.models.EnderecoFavorito;
import connect.go.models.EnderecoFavoritoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoFavoritoService {
    private final EnderecoFavoritoRepository enderecoFavoritoRepository;

    public EnderecoFavorito cadastrar(EnderecoFavoritoId enderecoFavoritoId) {
        EnderecoFavorito enderecoFavorito = new EnderecoFavorito();
        enderecoFavorito.setId(enderecoFavoritoId);
        return enderecoFavoritoRepository.save(enderecoFavorito);
    }
}
