package com.nepalyatra.dtos;

import lombok.Data;

@Data
public class VerifyDTO {
    private String email;
    private String otp;
}
