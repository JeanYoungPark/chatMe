package com.example.chatme.dto.user;

import com.example.chatme.domain.user.User;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class userDtoPo {

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private String nickName;

    public User toEntity(){
        return User.builder()
                .userId(this.userId)
                .password(this.password)
                .nickName(this.nickName)
                .build();
    }
}
