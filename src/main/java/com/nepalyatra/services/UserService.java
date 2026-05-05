package com.nepalyatra.services;

import com.nepalyatra.dtos.UserDTO;

public interface UserService {

    UserDTO createuser(UserDTO userDTO);

    UserDTO getUserById(Long id);
}
