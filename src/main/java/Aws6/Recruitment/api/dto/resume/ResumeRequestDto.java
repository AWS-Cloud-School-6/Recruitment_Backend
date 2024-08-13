package Aws6.Recruitment.api.dto.resume;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResumeRequestDto {

    private Long jobPostingId;
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String summary;
    private String education;
    private String experience;
    private String skills;
}