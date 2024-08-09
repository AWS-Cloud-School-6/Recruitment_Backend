package Aws6.Recruitment.api.dto.resume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeRequestDto {
    private String name;
    private String email;
    private String phone;
    private String summary;
    private String education;
    private String experience;
    private String skills;
    private Long userId;  // 사용자 ID
}