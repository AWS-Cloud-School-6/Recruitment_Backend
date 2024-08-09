package Aws6.Recruitment.api.dto.application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequestDto {
    private Long userId;
    private Long jobPostingId;
    private Long resumeId;
}