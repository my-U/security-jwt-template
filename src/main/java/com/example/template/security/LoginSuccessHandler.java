package com.example.NPKI.security;

import com.example.NPKI.domain.Member;
import com.example.NPKI.dto.response.LoginSuccessMemberDto;
import com.example.NPKI.dto.response.LoginSuccessResponse;
import com.example.NPKI.dto.response.TokenResponse;
import com.example.NPKI.repository.MemberRepository;
import com.example.NPKI.util.enums.SuccessCode;
import com.example.NPKI.util.enums.SuccessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final ObjectMapper objectMapper;
    private final MemberRepository memberRepository;

    @Value("${jwt.TOKEN_PREFIX}")
    private String TOKEN_PREFIX;

    @Value("${mediatype.json}")
    private String mediaTypeJson;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        String accountId = authentication.getName();

        // JWT 생성
        String accessToken = jwtService.createAccessToken(accountId);

        TokenResponse tokenResponse = new TokenResponse(accessToken, TOKEN_PREFIX);

        Member member = memberRepository.findByAccountId(accountId)
                .orElseThrow(() -> new UsernameNotFoundException("Member not found"));

        LoginSuccessMemberDto loginSuccessMemberDto = LoginSuccessMemberDto.builder()
                .accountId(member.getAccountId())
                .memberName(member.getMemberName())
                .role(member.getRole())
                .build();

        String refreshToken = jwtService.createRefreshToken(accountId);

        jwtService.sendRefreshToken(response, refreshToken);
        response.setContentType(mediaTypeJson);

        // JSON 응답 반환
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new SuccessResponse(SuccessCode.LOGIN_SUCCESS, new LoginSuccessResponse(tokenResponse, loginSuccessMemberDto))
                )
        );
    }
}
