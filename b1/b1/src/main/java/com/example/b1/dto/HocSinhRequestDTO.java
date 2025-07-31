package com.example.b1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HocSinhRequestDTO {
        private String maHS;
        private String hoTen;
        private Boolean gioiTinh;
        private LocalDate ngaySinh;
        private String maLop;
        private String tenLop;
        private String GVCN;
        private Double diem;


    }


