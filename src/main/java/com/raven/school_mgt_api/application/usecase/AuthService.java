package com.raven.school_mgt_api.application.usecase;

import com.raven.school_mgt_api.application.dto.request.LoginRequest;
import com.raven.school_mgt_api.application.dto.request.RegisterRequest;
import com.raven.school_mgt_api.application.dto.response.AuthResponse;
import com.raven.school_mgt_api.application.dto.response.UserResponse;
import com.raven.school_mgt_api.application.mapper.UserMapper;
import com.raven.school_mgt_api.domain.exception.UserException;
import com.raven.school_mgt_api.domain.model.User;
import com.raven.school_mgt_api.domain.model.enums.Role;
import com.raven.school_mgt_api.domain.repository.TokenProvider;
import com.raven.school_mgt_api.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                null,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );

        String token = tokenProvider.generateToken(authentication);
        UserResponse userResponse = userMapper.toResponse(user);

        return AuthResponse.builder()
                .token(token)
                .user(userResponse)
                .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserException("Email already in use");
        }
if (request.getRole() == Role.ROLE_ADMIN) {
    throw new UserException("Only admins can register this user");
}
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .isActive(true)
                .build();

        User savedUser = userRepository.save(user);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                savedUser.getEmail(),
                null,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + savedUser.getRole().name()))
        );

        String token = tokenProvider.generateToken(authentication);
        UserResponse userResponse = userMapper.toResponse(savedUser);

        return AuthResponse.builder()
                .token(token)
                .user(userResponse)
                .build();
    }

    @Override
    public AuthResponse logout() {
        SecurityContextHolder.clearContext();
        return AuthResponse.builder()
                .token(null)
                .user(null)
                .msg("logged out")
                .build();
    }
}
