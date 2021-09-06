package com.example.chatme.mapper;

import com.example.chatme.domain.chatting.Room;
import com.example.chatme.dto.chatting.RoomDtoPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomMapperPotoEntity {

    RoomMapperPotoEntity INSTANCE = Mappers.getMapper(RoomMapperPotoEntity.class);

    @Mapping(target="id", ignore = true)
    Room convert(RoomDtoPo roomDtoPo);

}
