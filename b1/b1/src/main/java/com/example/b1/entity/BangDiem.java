package com.example.b1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
    @Table(name = "BangDiem")
public class BangDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Diem")
    private Double diem;

    @ManyToOne
    @JoinColumn(name = "hoc_sinh_id")
    @JsonBackReference
    private HocSinh hocSinh;


    @ManyToOne
    @JoinColumn(name = "mon_hoc_id")
    @JsonBackReference(value = "monhoc-bangdiem")
    private MonHoc monHoc;



}
