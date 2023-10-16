package com.demo.demospring;


import com.demo.demospring.repository.*;
import com.demo.demospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean   // 등록할 스프링 빈
    public MemberService memberService(){
        return new MemberService(memberRepository());   // 스프링 빈에 등록한 Repository를 넣어줌
    }

    @Bean   // 등록할 스프링 빈
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository(); // 메모리
        // return new JdbcMemberRepository(dataSource); // Jdbc
        // return new JdbcTemplateMemberRepository(dataSource);   // Jdbc Template
        return new JpaMemberRepository(em);
    }
}
