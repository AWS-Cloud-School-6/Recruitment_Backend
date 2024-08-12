package Aws6.Recruitment.api.dto.user;

import Aws6.Recruitment.entity.user.User;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String username;
    private String email;

    public UserResponseDto(User user) {
        this.id=user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user);
    }
}
