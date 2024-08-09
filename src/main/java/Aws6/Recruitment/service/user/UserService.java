package Aws6.Recruitment.service.user;


import Aws6.Recruitment.api.dto.user.UserRequestDto;
import Aws6.Recruitment.entity.user.Role;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByUsername(userRequestDto.getUsername()) || userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new RuntimeException("Username or Email already exists");
        }

        User user = User.builder().username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .email(userRequestDto.getEmail())
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



}
