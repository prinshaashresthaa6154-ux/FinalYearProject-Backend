package com.nepalyatra.services.impl;

import com.nepalyatra.dtos.UserDTO;
import com.nepalyatra.entities.User;
import com.nepalyatra.exceptions.ResourceNotFoundException;
import com.nepalyatra.mapper.UserMapper;
import com.nepalyatra.repositories.UserRepository;
import com.nepalyatra.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createuser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser=  userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
      User user = userRepository.findById(id).
              orElseThrow(() -> new ResourceNotFoundException("User Maru"));
      return UserMapper.toDTO(user);



    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User Maru"));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
       User updateUser = userRepository.save(user);
       return UserMapper.toDTO(updateUser);

    }

    @Override
    public void deleteUser(Long id) {
       User user = userRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("User ID Not Found"));
        userRepository.delete(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List <User> users = userRepository.findAll();
        return users.stream().map (UserMapper::toDTO).collect(Collectors.toList());
    }
}
