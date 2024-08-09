package Aws6.Recruitment.service.user;


import Aws6.Recruitment.entity.user.Role;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername()) || userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Username or Email already exists");
        }
        user.setPassword(user.getPassword());
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
