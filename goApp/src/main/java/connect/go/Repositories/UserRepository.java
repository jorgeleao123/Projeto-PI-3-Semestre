package connect.go.Repositories;

import connect.go.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmailAndPassword(String email, String password);

}
