package connect.go.Repositories;

import connect.go.models.EnderecoFavorito;
import connect.go.models.EnderecoFavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoFavoritoRepository extends JpaRepository<EnderecoFavorito, EnderecoFavoritoId> {
}
