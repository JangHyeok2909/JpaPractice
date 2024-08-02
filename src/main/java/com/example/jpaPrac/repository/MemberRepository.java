package com.example.jpaPrac.repository;

import com.example.jpaPrac.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface MemberRepository {
    @Transactional
    public Member save(Member member);

    public Member findMemberById(Integer id);
    public List<Member> findAll();
    @Transactional
    public Member update(Integer id,Member member);
    @Transactional
    public void delete(Integer id);
}
