package com.group3.finalprojectbe.system.ctrl;

import cn.hutool.core.map.MapUtil;
import com.group3.finalprojectbe.system.config.SecContext;
import com.group3.finalprojectbe.system.dto.LoginRequest;
import com.group3.finalprojectbe.system.dto.RegisterRequest;
import com.group3.finalprojectbe.system.dto.UserDto;
import com.group3.finalprojectbe.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody RegisterRequest registerRequest) {
        String jwt = userService.registerUser(registerRequest);
        return ResponseEntity.ok(MapUtil.of("token", jwt));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginRequest loginRequest) {
        String jwt = userService.loginUser(loginRequest);
        return ResponseEntity.ok(MapUtil.of("token", jwt));
    }




}
