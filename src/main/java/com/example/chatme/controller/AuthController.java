package com.example.chatme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/auth/signin")
    public void signIn(){
        //로그인
    }

    @PostMapping("/auth/join")
    public void joinForm(){
        //회원가입
    }

}
