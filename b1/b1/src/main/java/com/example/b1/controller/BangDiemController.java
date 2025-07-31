package com.example.b1.controller;


import com.example.b1.entity.BangDiem;
import com.example.b1.service.BangDiemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bangdiem")
public class BangDiemController {
    private final BangDiemService bangDiemService;

    @GetMapping
    public ResponseEntity<List<BangDiem>> getAll() {
        return ResponseEntity.ok(bangDiemService.getAll());
    }

    @PostMapping
    public ResponseEntity<BangDiem> addBD(@RequestBody BangDiem bangDiem) {
        return ResponseEntity.ok(bangDiemService.create(bangDiem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BangDiem> update(@PathVariable Long id, @RequestBody BangDiem bangDiem) {
        return ResponseEntity.ok(bangDiemService.update(id, bangDiem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bangDiemService.delete(id);
        return ResponseEntity.ok("Xóa thành công!");
    }

}
