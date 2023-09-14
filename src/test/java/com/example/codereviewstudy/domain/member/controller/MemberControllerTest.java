package com.example.codereviewstudy.domain.member.controller;

import com.example.codereviewstudy.domain.member.dto.request.MemberSignUpRequest;
import com.example.codereviewstudy.domain.member.dto.response.MemberInfoResponse;
import com.example.codereviewstudy.domain.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = MemberController.class)
class MemberControllerTest {

    @MockBean
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void successSignUp() throws Exception {
        //given
        String email = "test@test.com";
        String password = "1234";
        String nickName = "AAA";
        Long memberId = 1L;
        given(memberService.signUp(any())).willReturn(
                new MemberInfoResponse(memberId, email, nickName));
        //when
        //then
        mockMvc.perform(post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new MemberSignUpRequest(
                                        "AAA", "BBB", "CCC")))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email")
                        .value("test@test.com"))
                .andDo(print())
        ;
    }

    @Test
    void successGetInfo() throws Exception {
        //given
        String email = "test@test.com";
        String nickName = "AAA";
        Long memberId = 1L;
        given(memberService.getMemberInfo(anyString())).willReturn(
                new MemberInfoResponse(memberId, email, nickName));
        //when
        //then
        mockMvc.perform(get("/members/{A}", "AAA@AAA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email")
                        .value("test@test.com"))
                .andDo(print())
        ;
    }
}