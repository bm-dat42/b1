package com.example.b1.service;


import com.example.b1.entity.BangDiem;
import com.example.b1.repository.BangDiemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BangDiemService {
    public final BangDiemRepository bangDiemRepository;

    public List<BangDiem> getAll() {
        return bangDiemRepository.findAll();
    }

    public BangDiem getById(Long id) {
        return bangDiemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bảng điểm ID: " + id));
    }

    public BangDiem create(BangDiem bangDiem) {
        return bangDiemRepository.save(bangDiem);
    }

    public BangDiem update(Long id, BangDiem bd) {
        BangDiem bangDiem = getById(id);
        bangDiem.setDiem(bd.getDiem());
        bangDiem.setHocSinh(bd.getHocSinh());
        bangDiem.setMonHoc(bd.getMonHoc());
        return bangDiemRepository.save(bangDiem);
    }

    public void delete(Long id) {
        bangDiemRepository.deleteById(id);
    }
}
