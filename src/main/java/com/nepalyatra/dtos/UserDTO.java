package com.nepalyatra.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;

}
