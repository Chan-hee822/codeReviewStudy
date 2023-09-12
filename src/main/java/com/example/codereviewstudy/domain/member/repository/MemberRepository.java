package com.example.codereviewstudy.domain.member.repository;


import com.example.codereviewstudy.domain.member.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository implements MemberRepositoryInterface {

    private final Map<String, Member> db = new HashMap<>();

    @Override
    public int size() {
        return db.size();
    }
    @Override
    public Member save(Member member) {
        db.put(member.getEmail(), member);
        return member;
    }
    @Override
    public Member findByEmail(String email) {
        return db.get(email);
    }
    @Override
    public boolean existsByEmail(String email) {
        return db.containsKey(email);
    }
    @Override
    public boolean existsByNickName(String email) {
        return db.values()
                .stream()
                .anyMatch(member -> member.getNickname().equals(email));
    }

}
