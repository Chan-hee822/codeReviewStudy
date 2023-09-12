package com.example.codereviewstudy.domain.member.dto.request;

import javax.validation.constraints.NotBlank;

public class MemberSignUpRequest {

    @NotBlank(message = "이메일값이 비어있을수 없습니다")
    private String email;
    @NotBlank(message = "비밀번호값이 비어있을수 없습니다")
    private String password;
    @NotBlank(message = "닉네임값이 비어있을수 없습니다")
    private String nickname;

    public MemberSignUpRequest() {
    }

    public MemberSignUpRequest(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    // getter & setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
