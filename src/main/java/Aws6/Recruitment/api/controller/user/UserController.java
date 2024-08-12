package Aws6.Recruitment.api.controller.user;

import Aws6.Recruitment.api.dto.user.LoginRequestDto;
import Aws6.Recruitment.api.dto.user.UserRequestDto;
import Aws6.Recruitment.api.dto.user.UserResponseDto;
import Aws6.Recruitment.entity.response.CommonResult;
import Aws6.Recruitment.entity.response.SingleResult;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.service.response.ResponseService;
import Aws6.Recruitment.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ResponseService responseService;

    @PostMapping
    public CommonResult registerUser(@RequestBody UserRequestDto userRequestDto) {
        userService.registerUser(userRequestDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("/login")
    public SingleResult<UserResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        User user = userService.loginUser(loginRequestDto);
        UserResponseDto userResponseDto = UserResponseDto.toDto(user);
        return responseService.getSingleResult(userResponseDto);
    }

//    @GetMapping("/{username}")
//    public SingleResult<UserResponseDto> getUser(@PathVariable("username") String username) {
//        User user = userService.findByUsername(username);
//        UserResponseDto userResponseDto = UserResponseDto.toDto(user);
//        return responseService.getSingleResult(userResponseDto);
//    }
}