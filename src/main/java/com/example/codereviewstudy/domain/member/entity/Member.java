package com.example.codereviewstudy.domain.member.entity;

import com.example.codereviewstudy.domain.common.baseEntity;

import javax.persistence.*;

// getter, NoArgsConstructor, AllArgsConstructor
// setter - entity 에 setter 만드는 것 지양
@Entity(name = "MEMBER")
public class Member extends baseEntity {

    @Id // 엔티티 내부에서 아이디임을 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 전략 선언
    @Column(name = "MEMBER_ID") // 아이디에 해당하는 컬럼명 선언
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    private String password;

    @Column(nullable = false, length = 30, unique = true)
    private String nickname;


    //NoArgsConstructor
    public Member() {

    }

    //AllArgsConstructor
    public Member(Long id, String email, String password, String nickname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }
}
