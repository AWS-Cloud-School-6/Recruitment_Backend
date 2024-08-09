package Aws6.Recruitment.api.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {

    private String username;
    private String password;
    private String email;
}
