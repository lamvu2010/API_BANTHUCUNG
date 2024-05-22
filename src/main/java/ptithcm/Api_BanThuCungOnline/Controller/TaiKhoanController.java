package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTOResponse.TaiKhoanDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Nhanvien;
import ptithcm.Api_BanThuCungOnline.Entity.Taikhoan;
import ptithcm.Api_BanThuCungOnline.Services.KhachHangService;
import ptithcm.Api_BanThuCungOnline.Services.NhanVienService;
import ptithcm.Api_BanThuCungOnline.Services.TaiKhoanService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tk")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private KhachHangService khachHangService;

    public TaiKhoanDTO convertToDTO(Taikhoan taikhoan){
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
        taiKhoanDTO.setTenDangNhap(taikhoan.getTendangnhap());
        taiKhoanDTO.setMatKhau(taikhoan.getMatkhau());
        taiKhoanDTO.setQuyen(taikhoan.getQuyen());
        return taiKhoanDTO;
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Taikhoan> list = new ArrayList<>();
        List<TaiKhoanDTO> dtoList = new ArrayList<>();
        list = taiKhoanService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>("Không có dữ liệu", HttpStatus.BAD_REQUEST);
        }
        for(Taikhoan taikhoan: list){
            TaiKhoanDTO taiKhoanDTO= convertToDTO(taikhoan);
            dtoList.add(taiKhoanDTO);
        }
        return new ResponseEntity<>(dtoList,HttpStatus.OK);
    }
}
