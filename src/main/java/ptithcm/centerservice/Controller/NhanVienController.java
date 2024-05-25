package ptithcm.centerservice.Controller;

import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.centerservice.DTOResponse.ChiNhanhDTO;
import ptithcm.centerservice.DTOResponse.NhanVienDTO;
import ptithcm.centerservice.Entity.Chinhanh;
import ptithcm.centerservice.Entity.Hinhanh;
import ptithcm.centerservice.Entity.Nhanvien;
import ptithcm.centerservice.Entity.Taikhoan;
import ptithcm.centerservice.Services.ChiNhanhService;
import ptithcm.centerservice.Services.NhanVienService;
import ptithcm.centerservice.Services.TaiKhoanService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private ChiNhanhService chiNhanhService;

    public NhanVienDTO convertToDTO(Nhanvien nhanvien) {
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        nhanVienDTO.setChiNhanh(new ChiNhanhDTO());
        nhanVienDTO.setMaNhanVien(nhanvien.getManhanvien());
        nhanVienDTO.setHo(nhanvien.getHo());
        nhanVienDTO.setTen(nhanvien.getTen());
        nhanVienDTO.setCccd(nhanvien.getCccd());
        nhanVienDTO.setEmail(nhanvien.getEmail());
        nhanVienDTO.setChucVu(nhanvien.getChucvu());
        nhanVienDTO.setSoDienThoai(nhanvien.getSodienthoai());
        if (nhanvien.getChinhanh() != null) {
            nhanVienDTO.getChiNhanh().setMaChiNhanh(nhanvien.getChinhanh().getMachinhanh());
            nhanVienDTO.getChiNhanh().setTenChiNhanh(nhanvien.getChinhanh().getTenchinhanh());
        }
        if (!nhanvien.getHinhanh().isEmpty()) {
            nhanVienDTO.setHinhAnh(new ArrayList<>());
            for (Hinhanh item : nhanvien.getHinhanh()) {
                nhanVienDTO.getHinhAnh().add(item.getMahinhanh());
            }
        }
        return nhanVienDTO;
    }

    @GetMapping
    public ResponseEntity<List<NhanVienDTO>> getAll() {
        List<Nhanvien> list = new ArrayList<>();
        List<NhanVienDTO> dtoList = new ArrayList<>();
        list = nhanVienService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        }
        for (Nhanvien nhanvien : list) {
            NhanVienDTO nhanVienDTO = convertToDTO(nhanvien);
            dtoList.add(nhanVienDTO);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

//    @GetMapping("/moi")
//    public String maNVMoi() {
//        return nhanVienService.maNhanVienMoi();
//    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody NhanVienDTO nhanVienDTO) {
        Nhanvien nhanvien = new Nhanvien();
        nhanvien.setCccd(nhanVienDTO.getCccd());
        nhanvien.setHo(nhanVienDTO.getHo());
        nhanvien.setEmail(nhanVienDTO.getEmail());
        nhanvien.setTen(nhanVienDTO.getTen());
        nhanvien.setChucvu(nhanVienDTO.getChucVu());
        nhanvien.setSodienthoai(nhanVienDTO.getSoDienThoai());
        nhanvien.setManhanvien(nhanVienService.maNhanVienMoi());
        if (nhanVienDTO.getChiNhanh() != null && nhanVienDTO.getChiNhanh().getMaChiNhanh() != 0) {
            nhanvien.setChinhanh(chiNhanhService.findById(nhanVienDTO.getChiNhanh().getMaChiNhanh()).orElse(null));
        }
        Taikhoan taikhoan = new Taikhoan();
        taikhoan.setTendangnhap(nhanvien.getManhanvien());
        taikhoan.setMatkhau("12345678910");
        taikhoan.setQuyen(Boolean.TRUE);
        taikhoan.setTrangthai(Boolean.TRUE);
        taikhoan = taiKhoanService.save(taikhoan);
        nhanvien = nhanVienService.save(nhanvien);
        NhanVienDTO nhanVienDTO1 = convertToDTO(nhanvien);
        return new ResponseEntity<>(nhanVienDTO1, HttpStatus.OK);
        // lấy thông tin tài khoản bằng request mới
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody NhanVienDTO nhanVienDTO) {
        if (!nhanVienService.isExistsById(nhanVienDTO.getMaNhanVien())) {
            return new ResponseEntity<>("Nhân viên không tồn tại", HttpStatus.BAD_REQUEST);
        }
        ;
        Nhanvien nhanvien = nhanVienService.findById(nhanVienDTO.getMaNhanVien()).get();
        nhanvien.setCccd(nhanVienDTO.getCccd());
        nhanvien.setHo(nhanVienDTO.getHo());
        nhanvien.setEmail(nhanVienDTO.getEmail());
        nhanvien.setTen(nhanVienDTO.getTen());
        nhanvien.setChucvu(nhanVienDTO.getChucVu());
        nhanvien.setSodienthoai(nhanVienDTO.getSoDienThoai());
        nhanvien.setManhanvien(nhanVienDTO.getMaNhanVien());
        nhanvien = nhanVienService.save(nhanvien);
        NhanVienDTO nhanVienDTO1 = convertToDTO(nhanvien);
        return new ResponseEntity<>(nhanVienDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        if (!nhanVienService.isExistsById(id)) {
            return new ResponseEntity<>("Nhân viên không tồn tại", HttpStatus.BAD_REQUEST);
        }
        nhanVienService.deleteById(id);
        if (!nhanVienService.isExistsById(id)) {
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Xóa thất bại", HttpStatus.BAD_REQUEST);
        }
    }
}
