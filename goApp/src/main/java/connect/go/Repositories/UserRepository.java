package connect.go.Repositories;

import connect.go.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.email=?2 where u.id=?1")
    Integer updateEmailById(Integer id, String email);

    @Transactional
    @Modifying
    @Query("update User u set u.password=?3 where u.id=?1 and u.password=?2")
    Integer updatePasswordById(Integer id, String oldPassword, String newPassword);

}
