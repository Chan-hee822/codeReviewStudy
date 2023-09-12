package com.example.codereviewstudy.domain.member.repository;

import com.example.codereviewstudy.domain.member.entity.Member;

public interface MemberRepositoryInterface {

    int size();
    Member save(Member member);
    Member findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNickName(String nickname);

}
