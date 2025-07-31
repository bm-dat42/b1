package com.example.b1.controller;

import com.example.b1.dto.HocSinhRequestDTO;
import com.example.b1.dto.HocSinhResponeDTO;
import com.example.b1.service.HocSinhService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hocsinh")
public class HocSinhController {

  private final HocSinhService hocSinhService;

  @GetMapping
  public List<HocSinhResponeDTO> getAllHocSinh() {
    return hocSinhService.getAll();

  }
  @GetMapping("/{id}")
  public ResponseEntity<HocSinhResponeDTO> getHocSinhById(@PathVariable Long id) {
    HocSinhResponeDTO dto = hocSinhService.getById(id);
    return ResponseEntity.ok(dto);

  }


  @PostMapping
  public ResponseEntity<String> addHocSinh(@RequestBody HocSinhRequestDTO hocSinhRequestDTO) {
    hocSinhService.add(hocSinhRequestDTO);
    return ResponseEntity.ok("Thêm học sinh thành công");
  }
  @PutMapping("/{id}")
  public ResponseEntity<String> updateHocSinh(@PathVariable Long id, @RequestBody HocSinhRequestDTO hocSinhRequestDTO) {
    hocSinhService.updateHocSinh(id, hocSinhRequestDTO);
    return ResponseEntity.ok("Sửa thành công");
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteHocSinh(@PathVariable Long id) {
    hocSinhService.deleteHocSinh(id);
    return ResponseEntity.ok("xoa thanh cong");
  }



}
