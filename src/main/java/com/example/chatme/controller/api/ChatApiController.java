package com.example.chatme.controller.api;

import com.example.chatme.domain.chatting.Room;
import com.example.chatme.dto.chatting.RoomDtoPo;
import com.example.chatme.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChatApiController {

    private final RoomService roomService;

    @PostMapping("/create/room")
    public Room create(@RequestBody RoomDtoPo roomDtoPo){
        Room room = roomService.save(roomDtoPo);
        System.out.println(room);
        return room;
    }

    @PostMapping("/get/room")
    public List<Room> get(){
        List<Room> rooms = roomService.findAll();
        return rooms;
    }

}
