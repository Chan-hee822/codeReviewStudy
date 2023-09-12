package com.example.codereviewstudy.domain.common;

public enum ErrorCode {

    // Member Error Code
    Duplicate_Email("이미 존재하는 이메일 입니다."),
    Duplicate_NickName("이미 존재하는 닉네임 입니다."),

    User_Not_Found("유저가 존재하지 않습니다.")

    //Board Error Code


    ;
    private final String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
