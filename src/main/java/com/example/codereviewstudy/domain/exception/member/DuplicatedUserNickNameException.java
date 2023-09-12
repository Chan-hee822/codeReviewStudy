package com.example.codereviewstudy.domain.exception.member;

import com.example.codereviewstudy.domain.common.ErrorCode;

public class DuplicatedUserNickNameException extends RuntimeException {
    public DuplicatedUserNickNameException() {
        super(ErrorCode.Duplicate_NickName.getDescription());
    }
}
