package com.nepalyatra.services;

import com.nepalyatra.dtos.UserDTO;

import java.util.List;

public interface        UserService {

    UserDTO createuser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    //Get All User//
    List<UserDTO> getAllUser();


}
