package connect.go.usecases;

import connect.go.Repositories.UserRepository;
import connect.go.exceptions.UserAlreadyExistsException;
import connect.go.exceptions.UserNotFoundException;
import connect.go.models.User;
import connect.go.models.dto.UserResponse;
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

    public void deleteById(Integer id) {
        if (this.userRepository.existsById(id)) {
            User user = getById(id);
            user.setStatus("inativo");
            userRepository.save(user);
        } else {
            throw new UserNotFoundException();
        }
    }

    public User getById(Integer id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public boolean updateById(Integer id, UserResponse userResponse) {
        if (userRepository.existsById(id)) {
            User user = getById(id);
            user.setEmail(userResponse.getEmail());
            user.setName(userResponse.getName());
            user.setGenre(userResponse.getGenre());
            user.setColorMenu(userResponse.getColorMenu());
            user.setColorProfile(userResponse.getColorProfile());
            user.setBirthDate(userResponse.getBirthDate());
            user.setRole(userResponse.getRole());
            userRepository.save(user);
            return true;
        }
        throw new UserNotFoundException();
    }

    public boolean updateEmailById(Integer id, String email) {
        if (userRepository.existsById(id)) {
            User user = getById(id);
            user.setEmail(email);
            userRepository.save(user);
            return true;
        }
        throw new UserNotFoundException();
    }

    public boolean updatePasswordById(Integer id, String oldPassword, String newPassword) {
        if (userRepository.existsById(id)) {
            return userRepository.updatePasswordById(id, oldPassword, newPassword).equals(1);
        }
        throw new UserNotFoundException();
    }

    private boolean isUserExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}