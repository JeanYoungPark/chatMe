package com.example.chatme.controller;

import com.example.chatme.config.auth.PrincipalDetails;
import com.example.chatme.domain.chatting.Room;
import com.example.chatme.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final RoomService roomService;

    @GetMapping("/chat")
    public String chat(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("user", principalDetails.getUser());
        return "chat";
    }

    @GetMapping("/room")
    public String room(){
        return "room";
    }

    @GetMapping("/move/room")
    public String chating(long roomNumber, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        roomService.findById(roomNumber);

        model.addAttribute("user", principalDetails.getUser());
        model.addAttribute("roomNumber", roomNumber);
        return "chat";
    }
}
