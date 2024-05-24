package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTOResponse.ChiNhanhDTO;
import ptithcm.Api_BanThuCungOnline.DTOResponse.NhanVienDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Hinhanh;
import ptithcm.Api_BanThuCungOnline.Entity.Nhanvien;
import ptithcm.Api_BanThuCungOnline.Services.NhanVienService;
import ptithcm.Api_BanThuCungOnline.Services.TaiKhoanService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    TaiKhoanService taiKhoanService;

    public NhanVienDTO convertToDTO(Nhanvien nhanvien){
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        nhanVienDTO.setChiNhanh(new ChiNhanhDTO());
        nhanVienDTO.setMaNhanVien(nhanvien.getManhanvien());
        nhanVienDTO.setHo(nhanvien.getHo());
        nhanVienDTO.setTen(nhanvien.getTen());
        nhanVienDTO.setCccd(nhanvien.getCccd());
        nhanVienDTO.setEmail(nhanvien.getEmail());
        nhanVienDTO.setChucVu(nhanvien.getChucvu());
        nhanVienDTO.setSoDienThoai(nhanvien.getSodienthoai());
        if(nhanvien.getChinhanh()!= null){
            nhanVienDTO.getChiNhanh().setMaChiNhanh(nhanvien.getChinhanh().getMachinhanh());
            nhanVienDTO.getChiNhanh().setTenChiNhanh(nhanvien.getChinhanh().getTenchinhanh());
        }
        if(!nhanvien.getHinhanh().isEmpty()){
            nhanVienDTO.setHinhAnh(new ArrayList<>());
            for (Hinhanh item : nhanvien.getHinhanh()){
                nhanVienDTO.getHinhAnh().add(item.getMahinhanh());
            }
        }
        return nhanVienDTO;
    }
    @GetMapping
    public ResponseEntity<List<NhanVienDTO>> getAll(){
        List<Nhanvien> list = new ArrayList<>();
        List<NhanVienDTO> dtoList = new ArrayList<>();
        list = nhanVienService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        }
        for (Nhanvien nhanvien : list){
            NhanVienDTO nhanVienDTO = convertToDTO(nhanvien);
            dtoList.add(nhanVienDTO);
        }
        return new ResponseEntity<>(dtoList,HttpStatus.OK);
    }

    @GetMapping("/moi")
    public String maNVMoi(){
        return nhanVienService.maNhanVienMoi();
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody NhanVienDTO nhanVienDTO){
        Nhanvien nhanvien = new Nhanvien();
        nhanvien.setCccd(nhanVienDTO.getCccd());
        nhanvien.setHo(nhanVienDTO.getHo());
        nhanvien.setEmail(nhanVienDTO.getEmail());
        nhanvien.setTen(nhanVienDTO.getTen());
        nhanvien.setChucvu(nhanVienDTO.getChucVu());
        nhanvien.setSodienthoai(nhanVienDTO.getSoDienThoai());
        return new ResponseEntity<>("",HttpStatus.OK);


    }

}
