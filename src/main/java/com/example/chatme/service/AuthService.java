package com.example.chatme.service;

import com.example.chatme.domain.user.User;
import com.example.chatme.domain.user.UserRepository;
import com.example.chatme.handler.ex.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    //스프링시큐리티 제공
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public User join(User user){
        User userExist = userRepository.findByUserId(user.getUserId());
        if(userExist == null){
            String rawPsw = user.getPassword();
            String encPsw = bCryptPasswordEncoder.encode(rawPsw);
            user.setPassword(encPsw);
            user.setRole("ROLE_USER");
            User userEntity = userRepository.save(user);

            return userEntity;
        }else {
            throw new CustomValidationException("같은 아이디가 존재합니다.");
        }
    }

}
