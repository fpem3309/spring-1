package com.demo.demospring;


import com.demo.demospring.repository.JdbcMemberRepository;
import com.demo.demospring.repository.JdbcTemplateMemberRepository;
import com.demo.demospring.repository.MemberRepository;
import com.demo.demospring.repository.MemoryMemberRepository;
import com.demo.demospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean   // 등록할 스프링 빈
    public MemberService memberService(){
        return new MemberService(memberRepository());   // 스프링 빈에 등록한 Repository를 넣어줌
    }

    @Bean   // 등록할 스프링 빈
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository(); // 메모리
        // return new JdbcMemberRepository(dataSource); // Jdbc
        return new JdbcTemplateMemberRepository(dataSource);   // Jdbc Template
    }
}
