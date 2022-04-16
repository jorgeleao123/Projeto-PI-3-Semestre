package connect.go.Repositories;

import connect.go.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User set email=?2 where id=?1")
    Integer updateEmailById(Integer id, String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User set password=?3 where id=?1 and password=?2")
    Integer updatePasswordById(Integer id, String oldPassword, String newPassword);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User set name=?2, email=?3, role=?4, sex=?5 where id=?1")
    Integer updateById(Integer id, String name, String email, String role, String sex);

}
