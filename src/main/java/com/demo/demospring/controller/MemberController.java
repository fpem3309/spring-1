package com.demo.demospring.controller;

import com.demo.demospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    // 스프링 컨테이너에 있는 memberService를 연결
    // 해당 Service에 @Service가 있어야(@Component가 있어야 스프링 빈으로 등록됨) 스프링 컨테이너가 관리
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
