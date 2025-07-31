package com.example.b1.controller;

import com.example.b1.dto.AuthRequest;
import com.example.b1.dto.AuthResponse;
import com.example.b1.dto.RegisterRequest;
import com.example.b1.entity.TaiKhoan;
import com.example.b1.repository.TaiKhoanRepository;
import com.example.b1.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TaiKhoanRepository taiKhoanRepository;
    private final AuthService authService;

    @PostMapping("/dangki")
    public ResponseEntity<?> dangki(@RequestBody RegisterRequest request){
        authService.dangki(request);
        return ResponseEntity.ok("Dangki thanh cong");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request){
        AuthResponse token = authService.login(request);
        return ResponseEntity.ok(token);
    }

    @GetMapping
    public ResponseEntity<List<TaiKhoan>> getAll() {
        return ResponseEntity.ok(taiKhoanRepository.findAll());
    }

}

