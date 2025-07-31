package com.example.b1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HocSinh")
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaHS")
    private String maHS;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;


    @ManyToOne
    @JoinColumn(name = "lop_id", referencedColumnName = "id")
    private LopHoc lopHoc;


    @OneToMany(mappedBy = "hocSinh", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BangDiem> bangDiems;


}
