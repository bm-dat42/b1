package com.example.b1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BangDiemResponeDTO {
    private String maHocSinh;
    private String tenHocSinh;
    private List<BangDiemDTO> bangDiems;
}
