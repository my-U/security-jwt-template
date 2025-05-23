package com.example.template.member.controller;

import com.example.template.member.dto.request.MemberRegisterDto;
import com.example.template.member.service.MemberService;
import com.example.template.util.ResponseUtil;
import com.example.template.util.enums.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberRegisterDto memberRegisterDto) {

        memberService.register(memberRegisterDto);
        return ResponseUtil.createSuccessResponse(SuccessCode.SIGNUP_SUCCESS);
    }
}
