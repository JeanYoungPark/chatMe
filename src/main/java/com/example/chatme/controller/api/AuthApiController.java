package com.example.chatme.controller.api;

import com.example.chatme.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthApiController {

    @PostMapping("/auth/signin")
    public void signIn(){
        //로그인
    }

}
