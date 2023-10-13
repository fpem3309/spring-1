package com.demo.demospring.controller;

import com.demo.demospring.domain.Member;
import com.demo.demospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    // 스프링 컨테이너에 있는 memberService를 연결
    // 해당 Service에 @Service가 있어야(또는 직접 등록을 하든 @Component가 있어야 스프링 빈으로 등록됨) 스프링 컨테이너가 관리
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName()); // 스프링이 name을 form.setName함
        memberService.join(member);

        return "redirect:/";    // 홈 화면 ("/")로 redirect
    }
}
