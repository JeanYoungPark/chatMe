package com.example.chatme.dto.chatting;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RoomDtoPo {

    @NotNull
    private String roomName;
}
