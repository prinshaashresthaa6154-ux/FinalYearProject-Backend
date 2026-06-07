package com.nepalyatra.mapper;

import com.nepalyatra.dtos.UserDTO;
import com.nepalyatra.entities.User;

public class Usermapper {
    public static UserDTO toDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getAuthProvider()
        );
    }

    public static User toEntity (UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getAuthProvider()
        );
    }
}
