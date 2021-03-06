package com.example.chatme.controller;

import com.example.chatme.domain.user.User;
import com.example.chatme.dto.user.UserDtoPo;
import com.example.chatme.mapper.UserMapperPotoEntity;
import com.example.chatme.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/auth/join")
    public String joinForm(UserDtoPo userDtoPo){
        authService.join(userDtoPo);

        return "/login";
    }

}
