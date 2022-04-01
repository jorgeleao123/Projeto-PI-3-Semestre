package connect.go.usecases;

import connect.go.Repositories.UserRepository;
import connect.go.exceptions.UserAlreadyExistsException;
import connect.go.exceptions.UserNotFoundException;
import connect.go.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(User user) {
        if (isUserExistsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        return this.userRepository.save(user);
    }

    public List<User> login(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
    }

    public void deleteById(Integer id) throws UserNotFoundException {
        if (this.userRepository.existsById(id)) {
            this.userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException();
        }
    }

    public User getById(Integer id) {
        return this.userRepository
                .findById(id)
                .orElseThrow();
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User updateById(Integer id, User user) throws UserNotFoundException {
        deleteById(id);
        user.setId(id);
        return this.register(user);
    }

    public boolean updateEmailById(Integer id, String email) {
        if(userRepository.existsById(id)) {
            return userRepository.updateEmailById(id, email).equals(1);
        }
        throw new UserNotFoundException();
    }

    public boolean updatePasswoordById(Integer id, String oldPassword, String newPassword) {
        if(userRepository.existsById(id)) {
            return userRepository.updatePasswordById(id, oldPassword, newPassword).equals(1);
        }
        throw new UserNotFoundException();
    }

    private boolean isUserExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
