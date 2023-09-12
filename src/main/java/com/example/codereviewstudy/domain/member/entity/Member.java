package com.example.codereviewstudy.domain.member.entity;

// getter, NoArgsConstructor, AllArgsConstructor
// setter - entity 에 setter 만드는 것 지양
public class Member {

    private Long id;

    private String email;

    private String password;

    private String nickname;

    public Member() {

    }

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
