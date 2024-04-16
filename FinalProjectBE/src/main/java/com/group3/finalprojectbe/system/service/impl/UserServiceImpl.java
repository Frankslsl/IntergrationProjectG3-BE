package com.group3.finalprojectbe.system.service.impl;


import com.group3.finalprojectbe.system.mapper.UserMapper;
import com.group3.finalprojectbe.system.config.JwtTokenProvider;
import com.group3.finalprojectbe.system.dto.LoginRequest;
import com.group3.finalprojectbe.system.dto.RegisterRequest;
import com.group3.finalprojectbe.system.dto.UserDto;
import com.group3.finalprojectbe.system.entity.User;
import com.group3.finalprojectbe.system.entity.UserPrincipal;
import com.group3.finalprojectbe.system.excption.BizExceptionKit;
import com.group3.finalprojectbe.system.repo.UserRepository;
import com.group3.finalprojectbe.system.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    private final UserMapper userMapper;

    public String registerUser(RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(registerRequest.getUsername());
        if (optionalUser.isEmpty()) {
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setPhoneNumber(registerRequest.getPhoneNumber());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            user.setEmail(registerRequest.getEmail());
            userRepository.save(user);


            UserPrincipal userPrincipal = new UserPrincipal(user, null);

            return jwtTokenProvider.generateToken(userPrincipal);
        }
        throw BizExceptionKit.of("Current user has bean registered");
    }

    @Override
    public String loginUser(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
        if (optionalUser.isPresent()) {
            String password = loginRequest.getPassword();
            BizExceptionKit.of("password is not correct").throwIfNot(passwordEncoder.matches(password, optionalUser.get().getPassword()));
            UserPrincipal userPrincipal = new UserPrincipal(optionalUser.get(), null);
            return jwtTokenProvider.generateToken(userPrincipal);
        }
        BizExceptionKit.of("Current user not exist").throwIt();
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->BizExceptionKit.of("Can not find the user by the user ID"));
        return userMapper.apply(user);

    }

    @Override
    @Transactional
    public String editUser(Long userId, RegisterRequest user) {
        User oldUser = userRepository.findById(userId).orElseThrow(() -> BizExceptionKit.of("User can not be found by the userId"));
        oldUser.setUsername(user.getUsername());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return jwtTokenProvider.generateToken(new UserPrincipal(oldUser, null));
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


}
