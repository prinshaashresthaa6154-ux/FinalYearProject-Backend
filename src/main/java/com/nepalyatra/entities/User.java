package com.nepalyatra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private int id;


    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(length = 10, nullable = false)
    private String password;

}
