package com.example.b1.dto;

import lombok.*;

@Getter
@Setter
@Data
public class AuthRequest {
    private String username;
    private String password;
}
