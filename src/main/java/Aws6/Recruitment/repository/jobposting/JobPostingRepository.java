package Aws6.Recruitment.repository.jobposting;

import Aws6.Recruitment.entity.jobposting.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}
