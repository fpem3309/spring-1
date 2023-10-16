package com.demo.demospring.repository;

import com.demo.demospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {  // Member 타입, id의 타입, MemberRepository

    @Override
    Optional<Member> findByName(String name);
}
