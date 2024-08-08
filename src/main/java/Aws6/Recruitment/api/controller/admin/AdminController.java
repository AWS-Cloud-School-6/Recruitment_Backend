package Aws6.Recruitment.api.controller.admin;

import Aws6.Recruitment.entity.application.Application;
import Aws6.Recruitment.entity.jobposting.JobPosting;
import Aws6.Recruitment.entity.notification.Notification;
import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.service.application.ApplicationService;
import Aws6.Recruitment.service.jobposting.JobPostingService;
import Aws6.Recruitment.service.notification.NotificationService;
import Aws6.Recruitment.service.resume.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

//    private final UserService userService;
    private final JobPostingService jobPostingService;
    private final ApplicationService applicationService;
    private final ResumeService resumeService;
    private final NotificationService notificationService;


    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }
//
//    @GetMapping("/users")
//    public String manageUsers(Model model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "admin/manage-users";
//    }

    @GetMapping("/job-postings")
    public String manageJobPostings(Model model) {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        model.addAttribute("jobPostings", jobPostings);
        return "admin/manage-job-postings";
    }

    @GetMapping("/applications")
    public String manageApplications(Model model) {
        List<Application> applications = applicationService.getAllApplications();
        model.addAttribute("applications", applications);
        return "admin/manage-applications";
    }

    @GetMapping("/resumes")
    public String manageResumes(Model model) {
        List<Resume> resumes = resumeService.getAllResumes();
        model.addAttribute("resumes", resumes);
        return "admin/manage-resumes";
    }

    @GetMapping("/notifications")
    public String manageNotifications(Model model) {
        List<Notification> notifications = notificationService.getAllNotifications();
        model.addAttribute("notifications", notifications);
        return "admin/manage-notifications";
    }
}