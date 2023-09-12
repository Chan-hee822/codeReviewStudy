package com.example.codereviewstudy.domain.member.dto.response;

import com.example.codereviewstudy.domain.member.entity.Member;

public class MemberInfoResponse {

    private Long memberId;

    private String email;

    private String nickname;

    public static MemberInfoResponse fromEntity(Member member) {
        return new MemberInfoResponse(member.getId(), member.getEmail(), member.getNickname());
    }

    public MemberInfoResponse() {
    }

    public MemberInfoResponse(Long memberId, String email, String nickname) {
        this.memberId = memberId;
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
