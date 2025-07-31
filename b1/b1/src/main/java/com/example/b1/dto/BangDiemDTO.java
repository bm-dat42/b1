package com.example.b1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BangDiemDTO {
    private Long id;
    private Double diem;
    private String tenMon;
}


