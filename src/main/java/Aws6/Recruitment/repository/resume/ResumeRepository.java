package Aws6.Recruitment.repository.resume;

import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findResumesByUser(User user);
}
