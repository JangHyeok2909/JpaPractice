package com.example.jpaPrac.repository;


import com.example.jpaPrac.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest

public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    Member member;
    @BeforeEach
    public void dataInit(){//save
        member=new Member();
        member.setName("장혁");
        member.setNickname("주인장");
        member.setLoginId("wkdgur");
        member.setPassword("password");
        Member savedMember = memberRepository.save(member);
        member.setId(savedMember.getId());
        assertThat(savedMember).isEqualTo(member);
    }

    @Test
    public void findMemberById(){
        Integer id = member.getId();
        Member findMember = memberRepository.findMemberById(id);
        assertThat(findMember).isEqualTo(member);
    }
    @Test
    public void findAll(){
        Member member1=new Member("sssss","ssss","ssssss","ssssssss");
        memberRepository.save(member1);
        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0)).isEqualTo(member);
        assertThat(all.get(1)).isEqualTo(member1);
        memberRepository.delete(all.get(1).getId());
    }

    @Test
    public void update(){
        member.setName("문철");
        memberRepository.update(member.getId(),member);
        Member findMember = memberRepository.findMemberById(member.getId());
        assertThat(findMember).isEqualTo(member);
    }
    @AfterEach
    public void dataClear(){ //delete
        memberRepository.delete(member.getId());
    }





}
