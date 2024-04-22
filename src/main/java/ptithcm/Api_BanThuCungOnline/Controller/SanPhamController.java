package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.Api_BanThuCungOnline.Entity.Loaisanpham;
import ptithcm.Api_BanThuCungOnline.Entity.Sanpham;
import ptithcm.Api_BanThuCungOnline.Services.LoaiSanPhamService;
import ptithcm.Api_BanThuCungOnline.Services.SanPhamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    LoaiSanPhamService loaiSanPhamService;

    @GetMapping
    public ResponseEntity<List<Sanpham>> findByIdLoai(){
        Optional<Loaisanpham> loaisanpham = loaiSanPhamService.findById(1);
        List<Sanpham> list = sanPhamService.findByIdLoai(loaisanpham.orElse(null));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
