package com.nepalyatra.controller;

import com.nepalyatra.dtos.UserDTO;
import com.nepalyatra.entities.User;
import com.nepalyatra.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.createuser(userDTO);
        System.out.println(savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserByTd(@PathVariable Long id){
           UserDTO user = userService.getUserById(id);
           return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO>updateUser(@PathVariable long id, @RequestBody UserDTO userDTO){
          UserDTO user =  userService.updateUser(id,userDTO);
          return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<UserDTO>deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(){
         List<UserDTO> users = userService.getAllUser();
         return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
