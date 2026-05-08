package com.raven.school_mgt_api.domain.repository;

import org.springframework.security.core.Authentication;

public interface TokenProvider {
    String generateToken(Authentication authentication);
    String getEmailFromToken(String token);
}
