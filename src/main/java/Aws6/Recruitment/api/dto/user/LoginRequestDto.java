package Aws6.Recruitment.api.dto.user;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String loginEmail;
    private String loginPw;
}
