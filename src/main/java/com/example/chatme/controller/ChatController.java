package com.example.chatme.controller;

import com.example.chatme.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chat(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("user", principalDetails.getUser());
        return "chat";
    }
}
