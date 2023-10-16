package com.demo.demospring;


import com.demo.demospring.aop.TimeTraceAop;
import com.demo.demospring.repository.*;
import com.demo.demospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    // Spring Data JPA가 구현체를 만들어 놓고 등록이 자동으로 됨
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean   // 등록할 스프링 빈
    public MemberService memberService(){
        return new MemberService(memberRepository);   // 스프링 빈에 등록한 Repository를 넣어줌
    }

    // 정형화되지 않은 특별한 경우 직접 Bean으로 생성하는게 나을듯
    // @Bean
    // public TimeTraceAop timeTraceAop(){
    // return new TimeTraceAop();
    // }


//    @Bean   // 등록할 스프링 빈
//    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository(); // 메모리
        // return new JdbcMemberRepository(dataSource); // Jdbc
        // return new JdbcTemplateMemberRepository(dataSource);   // Jdbc Template
//        return new JpaMemberRepository(em);
//    }
}
