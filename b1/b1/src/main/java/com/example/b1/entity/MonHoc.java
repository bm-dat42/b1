package com.example.b1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MonHoc")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaMon")
    private String maMon;

    @Column(name = "TenMon")
    private String tenMon;

    @OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "monhoc-bangdiem")
    private List<BangDiem> bangDiems;
}
