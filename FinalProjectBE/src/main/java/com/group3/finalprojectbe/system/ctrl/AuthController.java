package com.group3.finalprojectbe.system.ctrl;

import com.group3.finalprojectbe.system.dto.LoginRequest;
import com.group3.finalprojectbe.system.dto.RegisterRequest;
import com.group3.finalprojectbe.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        String jwt = userService.registerUser(registerRequest);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        String jwt = userService.loginUser(loginRequest);
        return ResponseEntity.ok(jwt);
    }

}
