package com.example.b1.repository;


import com.example.b1.entity.BangDiem;
import com.example.b1.entity.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BangDiemRepository extends JpaRepository<BangDiem, Long> {


    List<BangDiem> findByHocSinhId(Long hocSinhId);
    void deleteByHocSinh(HocSinh hocSinh);

}
