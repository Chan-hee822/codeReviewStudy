package com.example.codereviewstudy.domain.member.controller;

import com.example.codereviewstudy.domain.member.dto.request.MemberSignUpRequest;
import com.example.codereviewstudy.domain.member.dto.response.MemberInfoResponse;
import com.example.codereviewstudy.domain.member.dto.response.MemberSignUpResponse;
import com.example.codereviewstudy.domain.member.service.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class MemberController {
    private final MemberService memberService;

    // 생성자
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public MemberSignUpResponse signUp(
            @Valid @RequestBody MemberSignUpRequest request
    ) {
        return memberService.signUp(request);
    }

    @GetMapping("/members/{email}")
    public MemberInfoResponse getMemberInfo(
            @PathVariable String email
    ) {
        return memberService.getMemberInfo(email);
    }
}
