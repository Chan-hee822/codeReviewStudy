package com.example.codereviewstudy.domain.member.repository;


import com.example.codereviewstudy.domain.member.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    Map<String, Member> db = new HashMap<>();
//    public Member findById (Long id) {
//
//    }

    public int size() {
        return db.size();
    }

    public Member save(Member member) {
        db.put(member.getEmail(), member);
        return member;
    }

    public Member findByEmail(String email) {
        return db.get(email);
    }

    public boolean existsByEmail(String email) {

        return db.containsKey(email);

    }

    public boolean existsByNickName(String email) {

        for (Map.Entry<String, Member> item : db.entrySet()) {
            if (item.getValue().getNickname().equals(email)) {
                return true;
            }
        }

        return false;
    }

}
