package com.example.chatme.mapper;

import com.example.chatme.domain.user.User;
import com.example.chatme.dto.user.UserDtoPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapperPotoEntity {
    UserMapperPotoEntity INSTANCE = Mappers.getMapper(UserMapperPotoEntity.class);

    @Mapping(target = "id", constant = "0L")
    User convert(UserDtoPo userDtoPo);
}
