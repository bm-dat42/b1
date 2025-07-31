package com.example.b1.repository;

import com.example.b1.dto.HocSinhResponeDTO;
import com.example.b1.entity.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh, Long> {
    @Query("""
    SELECT new com.example.b1.dto.HocSinhResponeDTO(
        hs.maHS,
        hs.hoTen,
        hs.gioiTinh,
        hs.ngaySinh,
        lh.maLop,
        lh.tenLop,
        lh.GVCN,
        bd.diem
    )
    FROM HocSinh hs
    LEFT JOIN hs.lopHoc lh
    LEFT JOIN hs.bangDiems bd
""")
    List<HocSinhResponeDTO> getAllHS();
}

