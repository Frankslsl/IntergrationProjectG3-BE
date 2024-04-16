package com.group3.finalprojectbe.system.ctrl;

import cn.hutool.core.map.MapUtil;
import com.group3.finalprojectbe.system.config.SecContext;
import com.group3.finalprojectbe.system.dto.RegisterRequest;
import com.group3.finalprojectbe.system.dto.UserDto;
import com.group3.finalprojectbe.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.servlet.function.ServerResponse.ok;

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
    @PutMapping("/editUser/{userId}")
    public ResponseEntity<Map<String, String>> editUser(@PathVariable("userId") Long userId, @RequestBody RegisterRequest user){
        String newToken = userService.editUser(userId, user);
        return ResponseEntity.ok(MapUtil.of("token", newToken));
    }
}
