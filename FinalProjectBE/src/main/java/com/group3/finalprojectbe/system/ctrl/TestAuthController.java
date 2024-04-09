package com.group3.finalprojectbe.system.ctrl;

import com.group3.finalprojectbe.system.entity.User;
import com.group3.finalprojectbe.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class TestAuthController {

    private final UserService userService;

    @GetMapping("/getAllUser1")
    public ResponseEntity<?> getAllUser1() {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }


    @GetMapping("/getAllUser2")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<?> getAllUser2() {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/getAllUser3")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAllUser3() {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }


}
