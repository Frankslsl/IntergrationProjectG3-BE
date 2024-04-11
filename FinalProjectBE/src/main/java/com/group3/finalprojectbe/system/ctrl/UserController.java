package com.group3.finalprojectbe.system.ctrl;

import com.group3.finalprojectbe.system.config.SecContext;
import com.group3.finalprojectbe.system.dto.UserDto;
import com.group3.finalprojectbe.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:5174", allowCredentials = "true")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> fetchUserByUserId(@PathVariable Long userId){

        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }
    @GetMapping("/fetchUser")
    public ResponseEntity<UserDto> fetchUserByToken() {
        Long userId = SecContext.getUserId();
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }
}
