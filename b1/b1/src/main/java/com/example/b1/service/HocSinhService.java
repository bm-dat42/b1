package com.example.b1.service;

import com.example.b1.dto.HocSinhRequestDTO;
import com.example.b1.dto.HocSinhResponeDTO;
import com.example.b1.entity.BangDiem;
import com.example.b1.entity.HocSinh;
import com.example.b1.entity.LopHoc;
import com.example.b1.repository.BangDiemRepository;
import com.example.b1.repository.HocSinhRepository;
import com.example.b1.repository.LopHocRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class HocSinhService  {
    private final LopHocRepository lopHocRepository;
    private final HocSinhRepository hocSinhRepository;
    private final BangDiemRepository bangDiemRepository;

    public List<HocSinhResponeDTO> getAll(){
        return hocSinhRepository.getAllHS();
    }
    public void add( HocSinhRequestDTO dto){
        HocSinh hs = new HocSinh();
        hs.setMaHS(dto.getMaHS());
        hs.setHoTen(dto.getHoTen());
        hs.setNgaySinh(dto.getNgaySinh());
        hs.setGioiTinh(dto.getGioiTinh());



        LopHoc lop = lopHocRepository.findByMaLop( dto.getMaLop()).orElseGet(()->{
            LopHoc lh = new LopHoc();
            lh.setMaLop(dto.getMaLop());
            lh.setTenLop(dto.getTenLop());
            lh.setGVCN(dto.getGVCN());

            return lopHocRepository.save(lh);
                });
        hs.setLopHoc(lop);

        BangDiem bd = new BangDiem();
        bd.setDiem(dto.getDiem());
        hocSinhRepository.save(hs);
    }


    public void updateHocSinh(Long id, HocSinhRequestDTO dto){

        HocSinh hs = hocSinhRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("khong tim thay id:"+id));

        hs.setMaHS(dto.getMaHS());
        hs.setHoTen(dto.getHoTen());
        hs.setNgaySinh(dto.getNgaySinh());
        hs.setGioiTinh(dto.getGioiTinh());

        LopHoc lop = lopHocRepository.findByMaLop(dto.getMaLop()).orElseGet(()-> {
            LopHoc lh = new LopHoc();
            lh.setMaLop(dto.getMaLop());
            lh.setTenLop(dto.getTenLop());
            lh.setGVCN(dto.getGVCN());
            return lopHocRepository.save(lh);
        });
        hs.setLopHoc(lop);

        BangDiem bd = new BangDiem();
        bd.setDiem(dto.getDiem());

        hocSinhRepository.save(hs);
    }
@Transactional
    public  void deleteHocSinh( Long id){
       HocSinh hs= hocSinhRepository.findById(id)
               .orElseThrow(()->new RuntimeException("khong tim thay id: "+id));
       bangDiemRepository.deleteByHocSinh(hs);
       hocSinhRepository.delete(hs);

    }

    public HocSinhResponeDTO getById(Long id){
        HocSinh hs = hocSinhRepository.findById(id)
                 .orElseThrow(()-> new RuntimeException("khong tim thay id: "+id));
        HocSinhResponeDTO dto = new HocSinhResponeDTO();
        dto.setMaHS(hs.getMaHS());
        dto.setHoTen(hs.getHoTen());
        dto.setNgaySinh(hs.getNgaySinh());
        dto.setGioiTinh(hs.getGioiTinh());
        dto.setMaLop(hs.getLopHoc().getMaLop());
        dto.setTenLop(hs.getLopHoc().getTenLop());
        return dto;
    }
}
