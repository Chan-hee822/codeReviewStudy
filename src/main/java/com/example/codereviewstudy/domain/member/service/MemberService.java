package com.example.codereviewstudy.domain.member.service;

import com.example.codereviewstudy.domain.common.ErrorCode;
import com.example.codereviewstudy.domain.member.dto.request.MemberSignUpRequest;
import com.example.codereviewstudy.domain.member.dto.response.MemberInfoResponse;
import com.example.codereviewstudy.domain.member.entity.Member;
import com.example.codereviewstudy.domain.member.repository.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepositoryInterface memberRepository;

    @Autowired
    public MemberService(MemberRepositoryInterface memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberInfoResponse signUp(MemberSignUpRequest request) {
        boolean alreadyUseEmail = memberRepository.existsByEmail(request.getEmail());
        if (alreadyUseEmail) {
            ErrorCode.Duplicate_Email.throwException();
        }

        boolean alreadyUseNickname = memberRepository.existsByNickName(request.getNickname());
        if (alreadyUseNickname) {
            ErrorCode.Duplicate_NickName.throwException();
        }

        Long id = (long) (memberRepository.size() + 1);
        String email = request.getEmail();
        String password = request.getPassword();
        String nickName = request.getNickname();

        return MemberInfoResponse.from(memberRepository
                        .save(new Member(id, email, password, nickName)));
    }

    public MemberInfoResponse getMemberInfo(String email) {

        boolean alreadyUseEmail = memberRepository.existsByEmail(email);
        if (!alreadyUseEmail) {
            ErrorCode.User_Not_Found.throwException();
        }

        return MemberInfoResponse
                .from(memberRepository.findByEmail(email));

    }

}
