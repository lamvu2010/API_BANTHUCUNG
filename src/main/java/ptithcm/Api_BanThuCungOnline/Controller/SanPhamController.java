package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTOResponse.LoaiSanPhamDTO;
import ptithcm.Api_BanThuCungOnline.DTOResponse.SanPhamDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Loaisanpham;
import ptithcm.Api_BanThuCungOnline.Entity.Sanpham;
import ptithcm.Api_BanThuCungOnline.Services.LoaiSanPhamService;
import ptithcm.Api_BanThuCungOnline.Services.SanPhamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    LoaiSanPhamService loaiSanPhamService;

    // Lay danh sach san pham theo id loai
    @GetMapping("/loaiSanPham/{id}")
    public ResponseEntity<List<SanPhamDTO>> findByIdLoai(@PathVariable int id) {
        List<SanPhamDTO> list = new ArrayList<>();
        if (loaiSanPhamService.existsById(id)) {
            Optional<Loaisanpham> loaisanpham = loaiSanPhamService.findById(id);
            List<Sanpham> listSp = sanPhamService.findByIdLoai(loaisanpham.orElse(null));
            list = sanPhamDTO(listSp);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
    }

    // lay danh sach san pham
    @GetMapping
    public ResponseEntity<List<SanPhamDTO>> getAll() {
        List<Sanpham> list = sanPhamService.findAll();
        List<SanPhamDTO> listJson = sanPhamDTO(list);
        return new ResponseEntity<>(listJson, HttpStatus.OK);
    }

    // List san pham to list sanphamDTO
    public List<SanPhamDTO> sanPhamDTO(List<Sanpham> list) {
        List<SanPhamDTO> listJson = new ArrayList<>();
        for (Sanpham item : list) {
            SanPhamDTO sp = new SanPhamDTO();
            sp.setMaSanPham(item.getMasanpham());
            sp.setTenSanPham(item.getTensanpham());
            sp.setGiaHienTai(item.getGiahientai());
            sp.setLoaiSanPham(new LoaiSanPhamDTO());
            if (item.getLoaisanpham() != null) {
                sp.getLoaiSanPham().setMaLoaiSanPham(item.getLoaisanpham().getMaloaisanpham());
                sp.getLoaiSanPham().setTenLoaiSanPham(item.getLoaisanpham().getTenloaisanpham());
            }
            listJson.add(sp);
        }
        return listJson;
    }

    public SanPhamDTO convertToDTO(Sanpham sanpham) {
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        if(sanpham == null){
            return sanPhamDTO;
        }
        sanPhamDTO.setMaSanPham(sanpham.getMasanpham());
        sanPhamDTO.setTenSanPham(sanpham.getTensanpham());
        sanPhamDTO.setGiaHienTai(sanpham.getGiahientai());
        sanPhamDTO.setLoaiSanPham(new LoaiSanPhamDTO());
        if (sanpham.getLoaisanpham() != null) {
            sanPhamDTO.getLoaiSanPham().setMaLoaiSanPham(sanpham.getLoaisanpham().getMaloaisanpham());
            sanPhamDTO.getLoaiSanPham().setTenLoaiSanPham(sanpham.getLoaisanpham().getTenloaisanpham());
        }
        return sanPhamDTO;
    }

    // Them san pham
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody SanPhamDTO sanPhamDTO) {
        Sanpham sp = new Sanpham();
        sp.setTensanpham(sanPhamDTO.getTenSanPham());
        sp.setGiahientai(sanPhamDTO.getGiaHienTai());
        sp.setLoaisanpham(loaiSanPhamService.findById(sanPhamDTO.getLoaiSanPham().getMaLoaiSanPham()).orElse(null));
        sp = sanPhamService.save(sp);
        if (sanPhamService.existsById(sp.getMasanpham())) {
            SanPhamDTO sanPhamDTO1 = convertToDTO(sp);
            return new ResponseEntity<>(sanPhamDTO1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cap nhat that bai", HttpStatus.BAD_REQUEST);
        }
    }

    //Sua san pham
    @PutMapping
    public ResponseEntity<?> update(@RequestBody SanPhamDTO sanPhamDTO) {
        Sanpham sp = new Sanpham();
        if (!sanPhamService.existsById(sanPhamDTO.getMaSanPham())) {
            return new ResponseEntity<>(sp, HttpStatus.BAD_REQUEST);
        }
        sp.setMasanpham(sanPhamDTO.getMaSanPham());
        sp.setGiahientai(sanPhamDTO.getGiaHienTai());
        sp.setTensanpham(sanPhamDTO.getTenSanPham());
        sp.setLoaisanpham(loaiSanPhamService.findById(sanPhamDTO.getLoaiSanPham().getMaLoaiSanPham()).orElse(null));
        sp = sanPhamService.save(sp);
        SanPhamDTO sanPhamDTO1 = convertToDTO(sp);
        return new ResponseEntity<>(sanPhamDTO1, HttpStatus.OK);
    }

    // Xoa san pham
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean spTonTai = sanPhamService.existsById(id);
        if (spTonTai == false) {
            return new ResponseEntity<>("Id khong ton tai", HttpStatus.NOT_FOUND);
        }
        Optional<Sanpham> sanpham = sanPhamService.findById(id);
        sanPhamService.delete(sanpham.orElse(null));
        spTonTai = sanPhamService.existsById(id);
        if (spTonTai == true) {
            return new ResponseEntity<>("Xoa that bai", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Xoa thanh cong", HttpStatus.OK);
        }
    }
}
