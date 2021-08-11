package com.example.chatme.dto.user;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserDtoPo {

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private String nickName;

}
