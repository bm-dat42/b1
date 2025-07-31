package com.example.b1.repository;

import com.example.b1.entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LopHocRepository extends JpaRepository<LopHoc, Long> {
    Optional<LopHoc> findByMaLop(String maLop);


}
