package com.example.jpaPrac.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data

public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nickname",nullable = false,unique = true)
    @Size(min=2,max=12,message = "nickname must be 2~12 length")
    private String nickname;

    @Column(name="name",nullable = false)
    @Size(min=2,max=6,message = "name must be 2~6 length")
    private String name;

    @Column(name="loginId",nullable = false)
    @Size(min=6,max=15,message = "loginId must be 6~15 length")
    private String loginId;

    @Column(name="password",nullable = false)
    @Size(min=8,max=20,message = "password must be 8~20 length")
    private String password;

    public Member() {
    }

    public Member(String nickname, String name, String loginId, String password) {
        this.nickname = nickname;
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }
}
