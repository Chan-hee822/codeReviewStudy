package com.example.codereviewstudy.domain.member.service;

import com.example.codereviewstudy.domain.common.ErrorCode;
import com.example.codereviewstudy.domain.member.dto.request.MemberSignUpRequest;
import com.example.codereviewstudy.domain.member.dto.response.MemberInfoResponse;
import com.example.codereviewstudy.domain.member.dto.response.MemberSignUpResponse;
import com.example.codereviewstudy.domain.member.entity.Member;
import com.example.codereviewstudy.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    // sign up 테스트 성공/실패
    @Test
    void successSignUp() {
        //given
        Member member = new Member(
                1L, "AAA@AAA", "!234", "hong");
        given(memberRepository.save(any())).willReturn(member);
        //when
        MemberSignUpResponse response = memberService.signUp(
                new MemberSignUpRequest(
                        "BBB@BBB", "!@#$56", "gil"));
        //then
        assertEquals(1L, response.getMemberId());
    }

    @Test
    void failedSignUpForDuplicateEmail() {
        //given
        given(memberRepository.existsByEmail(anyString()))
                .willReturn(true);
        //when
        RuntimeException exception =
                assertThrows(IllegalArgumentException.class, () ->
                        memberService.signUp(new MemberSignUpRequest(
                                "BBB@BBB", "!@#$56", "gil")));
        //then
        assertEquals(ErrorCode.Duplicate_Email.getDescription()
                , exception.getMessage());
    }

    @Test
    void failedSignUpForDuplicateNickName() {
        //given
        given(memberRepository.existsByNickName(anyString()))
                .willReturn(true);
        //when
        RuntimeException exception =
                assertThrows(IllegalArgumentException.class, () ->
                        memberService.signUp(new MemberSignUpRequest(
                                "BBB@BBB", "!@#$56", "gil")));
        //then
        assertEquals(ErrorCode.Duplicate_NickName.getDescription()
                , exception.getMessage());
    }

    // get info 테스트 성공/실패
    @Test
    void successGetMemberInfo() {
        //given
        Member member = new Member(
                1L, "AAA@AAA", "!234", "hong");
        given(memberRepository.existsByEmail(anyString()))
                .willReturn(true);
        given(memberRepository.findByEmail(anyString())).willReturn(member);
        //when
        MemberInfoResponse response =
                memberService.getMemberInfo("AAA@BBB");
        //then
        assertEquals("AAA@AAA", response.getEmail());
    }

    @Test
    void failedGetMemberInfoForUserNotFound() {
        //given
        given(memberRepository.existsByEmail(anyString()))
                .willReturn(false);
        //when
        RuntimeException exception =
                assertThrows(IllegalArgumentException.class, () ->
                        memberService.getMemberInfo("AAA@CCC"));
        //then
        assertEquals(ErrorCode.User_Not_Found.getDescription()
                , exception.getMessage());
    }
}