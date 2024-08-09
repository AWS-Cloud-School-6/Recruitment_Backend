package Aws6.Recruitment.api.dto.jobposting;

import lombok.Data;

@Data
public class JobPostingRequestDto {

    private String title;
    private String description;
    private String company;
    private String location;
}
