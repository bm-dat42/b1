package com.example.b1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBcrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "123456@";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Raw password: " + rawPassword);
        System.out.println("Encoded password: " + encodedPassword);

        // Kiểm tra lại
        boolean matches = encoder.matches("123456@", encodedPassword);
        System.out.println("Password khớp? " + matches);
    }
}
