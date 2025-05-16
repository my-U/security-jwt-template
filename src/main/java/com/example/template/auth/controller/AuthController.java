package com.example.template.auth.controller;

import com.example.template.auth.dto.response.TokenResponseDto;
import com.example.template.auth.service.AuthService;
import com.example.template.util.ResponseUtil;
import com.example.template.util.enums.SuccessCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        authService.logout(request);  // 토큰 블랙리스트 등 처리
        return ResponseUtil.createSuccessResponse(SuccessCode.LOGOUT_SUCCESS);
    }

    @PostMapping("/token")
    public ResponseEntity<?> refresh(@CookieValue(value = "RefreshToken", required = false) String refreshToken) {
        TokenResponseDto tokenResponseDto = authService.refreshAccessToken(refreshToken);
        return ResponseUtil.createSuccessResponse(SuccessCode.REFRESH_TOKEN_SUCCESS, tokenResponseDto);
    }
}
