package com.demo.demospring.service;

import com.demo.demospring.domain.Member;
import com.demo.demospring.repository.MemberRepository;
import com.demo.demospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional  // JPA로 데이터를 저장/변경할 때 있어야 함
public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // Dependency Injection
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return Long
     */
    public Long join(Member member){
        
        // 같은 이름 중복 x
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 회원 이름 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> { // 값이 있으면(ifPresent = 옵셔널 객체의 메소드)
                throw new IllegalStateException("이미 존재하는 회원 이름입니다.");
            });
    }

    /**
     * 전체 회원 조회
     * @return List<Member>
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
