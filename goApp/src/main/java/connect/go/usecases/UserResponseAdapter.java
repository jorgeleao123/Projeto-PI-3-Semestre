package connect.go.usecases;

import connect.go.models.User;
import connect.go.models.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserResponseAdapter {

    public UserResponse execute(User user) {
        return new UserResponse(
                user.getId(), user.getName(), user.getEmail(), user.getRole(),
                user.getSex());
    }

    public List<UserResponse> execute(List<User> users) {
        List<UserResponse> responseUsers = new ArrayList<>();
        for (User user : users) {
            responseUsers.add(execute(user));
        }
        return responseUsers;
    }

}
