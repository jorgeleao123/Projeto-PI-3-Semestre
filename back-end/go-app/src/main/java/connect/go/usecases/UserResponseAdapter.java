package connect.go.usecases;

import connect.go.models.User;
import connect.go.models.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserResponseAdapter {

    private final ComplaintService complaintService;

    public UserResponse execute(User user) {
        return new UserResponse(
                user.getId(), user.getName(), user.getEmail(), user.getRole(),
                user.getGenre(), user.getColorProfile(), user.getColorMenu(), user.getBirthDate(), user.getStatus(),
                user.getSearchCounter(), getPostCounter(user.getId()), user.getCity());
    }

    public List<UserResponse> execute(List<User> users) {
        List<UserResponse> responseUsers = new ArrayList<>();
        for (User user : users) {
            responseUsers.add(execute(user));
        }
        return responseUsers;
    }

    private Integer getPostCounter(Integer userId) {
        return complaintService.countByUserId(userId);
    }

}
