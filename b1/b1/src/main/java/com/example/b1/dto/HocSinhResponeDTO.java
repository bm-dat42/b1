package com.example.b1.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Builder

public class HocSinhResponeDTO {

    private String maHS;
    private String hoTen;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private String maLop;
    private String tenLop;
    private String GVCN;
    private Double diem;

    public HocSinhResponeDTO(String maHS, String hoTen, Boolean gioiTinh, LocalDate ngaySinh,
                             String maLop, String tenLop,String GVCN, Double diem) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.GVCN = GVCN;
        this.diem = diem;
    }



}
