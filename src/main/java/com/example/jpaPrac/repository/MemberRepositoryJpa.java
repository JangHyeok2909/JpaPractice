package com.example.jpaPrac.repository;

import com.example.jpaPrac.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberRepositoryJpa implements MemberRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member findMemberById(Integer id) {
        Member findMember = em.find(Member.class, id);
        return findMember;
    }

    @Override
    public List<Member> findAll() {
        String jpql="select m from Member m";
        List<Member> allMember = em.createQuery(jpql, Member.class).getResultList();
        return allMember;
    }

    @Override
    public Member update(Integer id,Member member) {
        Member targetMember = em.find(Member.class, id);
        targetMember.setName(member.getName());
        targetMember.setPassword(member.getPassword());
        targetMember.setNickname(member.getNickname());
        targetMember.setLoginId(member.getLoginId());
        return targetMember;
    }

    @Override
    public void delete(Integer id) {
        Member member = em.find(Member.class, id);
        em.remove(member);
    }

}
