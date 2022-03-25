package connect.go.Repositories;

import connect.go.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    boolean existsByCep(String cep);

    List<Endereco> findAllByCep(String cep);

}
