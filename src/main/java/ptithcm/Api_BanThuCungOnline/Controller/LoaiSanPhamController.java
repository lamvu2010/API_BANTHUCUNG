package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTO.LoaiSanPhamDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Loaisanpham;
import ptithcm.Api_BanThuCungOnline.Services.LoaiSanPhamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loaisanpham")
public class LoaiSanPhamController {
    @Autowired
    LoaiSanPhamService loaiSanPhamService;

    @GetMapping
    public ResponseEntity<List<Loaisanpham>> getAll() {
        List<Loaisanpham> list = new ArrayList<>();
        list = loaiSanPhamService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Loaisanpham> loaisanpham = loaiSanPhamService.findById(id);
        if (loaisanpham.isEmpty()) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(loaisanpham, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody String tenLoaiSanPham) {
        if (loaiSanPhamService.existsByTenLoai(tenLoaiSanPham)) {
            return new ResponseEntity<>("Entity is existed", HttpStatus.BAD_REQUEST);
        }
        Loaisanpham loaisanpham = new Loaisanpham();
        loaisanpham.setTenloaisanpham(tenLoaiSanPham);
        Loaisanpham loaisanphamSaved = loaiSanPhamService.save(loaisanpham);
        if (loaisanphamSaved != null && loaisanphamSaved.getMaloaisanpham() > 0) {
            return new ResponseEntity<>(loaisanphamSaved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot save entity. Try again", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Validated LoaiSanPhamDTO loaiSanPhamDTO) {
        Loaisanpham loaisanpham = new Loaisanpham();
        if (!loaiSanPhamService.existsById(loaiSanPhamDTO.getMaLoaiSanPham())) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        }
        loaisanpham.setMaloaisanpham(loaiSanPhamDTO.getMaLoaiSanPham());
        loaisanpham.setTenloaisanpham(loaiSanPhamDTO.getTenLoaiSanPham());
        loaiSanPhamService.save(loaisanpham);
        return new ResponseEntity<>(loaisanpham, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean existsIdBeforeDelete = loaiSanPhamService.existsById(id);
        if (!existsIdBeforeDelete) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        }

        loaiSanPhamService.deleteById(id);

        boolean existsIdAfterDelete = loaiSanPhamService.existsById(id);
        if (existsIdAfterDelete) {
            return new ResponseEntity<>("Failed to delete entity", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Success to delete entity", HttpStatus.OK);
        }
    }

}
