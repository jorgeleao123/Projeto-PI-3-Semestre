package connect.go.controllers;

import connect.go.exceptions.BadRequestException;
import connect.go.exceptions.UserNotFoundException;
import connect.go.models.Address;
import connect.go.models.FavoriteAddressId;
import connect.go.models.User;
import connect.go.models.UserRegistration;
import connect.go.models.UserResponse;
import connect.go.usecases.FavoriteAddressService;
import connect.go.usecases.AddressService;
import connect.go.usecases.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AddressService addressService;

    private final FavoriteAddressService favoriteAddressService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRegistration userRegistration) {
        User user = userService.register(userRegistration.getUser());
        Address addressRegistration = userRegistration.getAddress();
        Address address = addressService.register(addressRegistration);
        FavoriteAddressId favoriteAddressId = new FavoriteAddressId();
        favoriteAddressId.setAddressId(address.getId());
        favoriteAddressId.setUserId(user.getId());
        favoriteAddressService.register(favoriteAddressId);
        return ResponseEntity.status(201).body(this.convertUserToUserResponse(user));
    }

    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<Object> loginUser(@PathVariable String email, @PathVariable String password) {
        List<User> users = userService.login(email, password);
        if (users.size() != 1) {
            throw new BadRequestException();
        }
        return ResponseEntity.status(200).body(this.convertUserToUserResponse(users.get(0)));
    }

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        List<User> users = userService.findAll();
        List<UserResponse> responseUser = new ArrayList<>();
        for (User user : users) {
            responseUser.add(convertUserToUserResponse(user));
        }
        return ResponseEntity.status(200).body(responseUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        User user = userService.getById(id);
        return ResponseEntity.status(200).body(convertUserToUserResponse(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable int id, @RequestBody @Valid User user) {
        user.setId(id);
        userService.updateById(id, user);
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/email/{id}/{email}")
    public ResponseEntity<Object> updateUserById(@PathVariable int id, @PathVariable String email) {
        if (userService.updateEmailById(id, email)){
            return ResponseEntity.status(200).build();
        }
        throw new BadRequestException();
    }

    @PatchMapping("/password/{id}/{oldPassword}/{newPassword}")
    public ResponseEntity<Object> updateUserById(@PathVariable int id, @PathVariable String oldPassword,
                                                 @PathVariable String newPassword) {
        if(userService.updatePasswoordById(id, oldPassword, newPassword)){
            return ResponseEntity.status(200).build();
        }
        throw new BadRequestException();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }

    private UserResponse convertUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse(
                user.getId(), user.getName(), user.getEmail(), user.getRole(),
                user.getSex());
        return userResponse;
    }
}
