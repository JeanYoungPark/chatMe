package com.example.chatme.service;

import com.example.chatme.domain.chatting.Room;
import com.example.chatme.domain.chatting.RoomRepository;
import com.example.chatme.dto.chatting.RoomDtoPo;
import com.example.chatme.handler.ex.CustomValidationException;
import com.example.chatme.mapper.RoomMapperPotoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapperPotoEntity roomMapperPotoEntity;

    public Room save(RoomDtoPo roomDtoPo){
        Room room = roomMapperPotoEntity.convert(roomDtoPo);
        Room roomSaved = roomRepository.save(room);
        return roomSaved;
    }

    public List<Room> findAll(){
        List<Room> rooms = roomRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        if(rooms.isEmpty()) rooms = null;
        return rooms;
    }

    public Room findById(long roomNumber){
        Room room = roomRepository.findById(roomNumber).orElseThrow(()-> new CustomValidationException("존재하지 않는 방입니다."));
        return room;
    }

}
