package com.example.Example.user.assembler;

import com.example.Example.user.model.User;
import com.example.Example.user.model.UserDto;
import org.springframework.stereotype.Component;


@Component
public class UserAssembler {

    public UserDto map(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());

        return dto;
    }

    public void update(User user, UserDto dto) {
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

    }


}
