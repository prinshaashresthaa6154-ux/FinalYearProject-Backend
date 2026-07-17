package com.nepalyatra.dtos;

import com.nepalyatra.dtos.enums.AuthProvider;
import com.nepalyatra.dtos.enums.Role;
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

    private Role role;
    private AuthProvider authProvider;

}
