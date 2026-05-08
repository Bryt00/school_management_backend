package com.raven.school_mgt_api.infrastructure.web.controller;

import com.raven.school_mgt_api.application.dto.request.LoginRequest;
import com.raven.school_mgt_api.application.dto.request.RegisterRequest;
import com.raven.school_mgt_api.application.dto.response.AuthResponse;
import com.raven.school_mgt_api.application.usecase.AuthUseCase;
import com.raven.school_mgt_api.infrastructure.web.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Endpoints for user login and registration")
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/login")
    @Operation(summary = "Login a user", description = "Returns a JWT token if credentials are valid")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody LoginRequest request) {
        AuthResponse response = authUseCase.login(request);
        return ResponseEntity.ok(ApiResponse.success("Login successful", response));
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Creates a new user and returns a JWT token")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody RegisterRequest request) {
        AuthResponse response = authUseCase.register(request);
        return ResponseEntity.ok(ApiResponse.success("User registered successfully", response));
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout a user", description = "Clears the security context on the server")
    public ResponseEntity<ApiResponse<String>> logout() {
        authUseCase.logout();
        return ResponseEntity.ok(ApiResponse.success("Logout successful", null));
    }
}
