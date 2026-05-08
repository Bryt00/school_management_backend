package com.raven.school_mgt_api.application.usecase;

import com.raven.school_mgt_api.application.dto.request.LoginRequest;
import com.raven.school_mgt_api.application.dto.request.RegisterRequest;
import com.raven.school_mgt_api.application.dto.response.AuthResponse;

public interface AuthUseCase {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
    AuthResponse logout();
}
