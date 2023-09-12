package com.example.codereviewstudy.domain.member.service;

import com.example.codereviewstudy.domain.exception.member.DuplicatedUserEmailException;
import com.example.codereviewstudy.domain.exception.member.DuplicatedUserNickNameException;
import com.example.codereviewstudy.domain.exception.member.UserNotFoundException;
import com.example.codereviewstudy.domain.member.dto.request.MemberSignUpRequest;
import com.example.codereviewstudy.domain.member.dto.response.MemberInfoResponse;
import com.example.codereviewstudy.domain.member.dto.response.MemberSignUpResponse;
import com.example.codereviewstudy.domain.member.entity.Member;
import com.example.codereviewstudy.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberSignUpResponse signUp(MemberSignUpRequest request) {

        boolean alreadyUseEmail = memberRepository
                .existsByEmail(request.getEmail());
        if (alreadyUseEmail) {
            throw new DuplicatedUserEmailException();
        }

        boolean alreadyUseNickname = memberRepository
                .existsByNickName(request.getNickname());
        if (alreadyUseNickname) {
            throw new DuplicatedUserNickNameException();
        }

        Long id = (long) (memberRepository.size() + 1);
        String email = request.getEmail();
        String password = request.getPassword();
        String nickName = request.getNickname();

        return MemberSignUpResponse
                .fromEntity(memberRepository
                        .save(new Member(id, email, password, nickName)));
    }

    public MemberInfoResponse getMemberInfo(String email) {

        boolean alreadyUseEmail = memberRepository.existsByEmail(email);
        if (!alreadyUseEmail) {
            throw new UserNotFoundException();
        }

        return MemberInfoResponse
                .fromEntity(memberRepository.findByEmail(email));

    }

}
