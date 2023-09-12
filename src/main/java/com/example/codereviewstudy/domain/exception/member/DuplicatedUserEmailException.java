package com.example.codereviewstudy.domain.exception.member;

import com.example.codereviewstudy.domain.common.ErrorCode;

public class DuplicatedUserEmailException extends RuntimeException {
    public DuplicatedUserEmailException() {
        super(ErrorCode.Duplicate_Email.getDescription());
    }
}
