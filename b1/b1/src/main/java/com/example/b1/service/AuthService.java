package com.example.b1.service;

import com.example.b1.config.JwtUtils;
import com.example.b1.dto.AuthRequest;
import com.example.b1.dto.AuthResponse;
import com.example.b1.dto.RegisterRequest;
import com.example.b1.entity.TaiKhoan;
import com.example.b1.repository.TaiKhoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    public final TaiKhoanRepository taikhoanRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public void dangki(RegisterRequest request){
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUsername(request.getUsername());
        String encodePassword = passwordEncoder.encode(request.getPassword());
        taiKhoan.setPassword(encodePassword);

        taikhoanRepository.save(taiKhoan);
    }

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()

                )
        );


        User user = (User) authentication.getPrincipal();

        String token = jwtUtils.generateToken(user);

        return new AuthResponse(token);
    }
}
