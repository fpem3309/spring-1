package com.demo.demospring;


import com.demo.demospring.repository.MemberRepository;
import com.demo.demospring.repository.MemoryMemberRepository;
import com.demo.demospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean   // 등록할 스프링 빈
    public MemberService memberService(){
        return new MemberService(memberRepository());   // 스프링 빈에 등록한 Repository를 넣어줌
    }

    @Bean   // 등록할 스프링 빈
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
