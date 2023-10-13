package com.demo.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        // resources->templates에 있는 hello를 렌더링(뷰 리졸버)
        // 기본 세팅 : `resources:templates/`+{ViewName}+`.html`
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // 응답 바디에 내용을 직접 넣음 (view로 x)
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;    // 문자 자체를 리턴(ResponseBody -> HTTPMessageConverter -> StringConverter)
    }

    @GetMapping("hello-api")
    @ResponseBody   // 응답 바디에 내용을 직접 넣음 (view로 x)
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;  // 객체는 default로 json 형식으로 리턴(ResponseBody -> HTTPMessageConverter -> JsonConverter)
    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
