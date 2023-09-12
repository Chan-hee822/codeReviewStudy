package com.example.codereviewstudy.domain.exception.member;

import com.example.codereviewstudy.domain.common.ErrorCode;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ErrorCode.User_Not_Found.getDescription());
    }
}
