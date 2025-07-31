package com.example.b1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @Column(unique = true)
    @Column(name = "tenDangNhap")
    private String username;
    @Column(name = "matKhau")
    private String password;

    @OneToOne
    @JoinColumn(name = "hoc_sinh_id")
    private HocSinh hocSinh;
}
