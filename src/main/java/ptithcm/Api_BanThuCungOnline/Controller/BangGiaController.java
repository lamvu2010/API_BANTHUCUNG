package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTOResponse.BangGiaDTO;
import ptithcm.Api_BanThuCungOnline.DTOResponse.ChiNhanhDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Banggia;
import ptithcm.Api_BanThuCungOnline.Services.BangGiaService;
import ptithcm.Api_BanThuCungOnline.Services.ChiNhanhService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/banggia")
public class BangGiaController {

    @Autowired
    BangGiaService bangGiaService;
    @Autowired
    ChiNhanhService chiNhanhService;

    public BangGiaDTO convertToDTO(Banggia banggia) {
        BangGiaDTO bangGiaDTO = new BangGiaDTO();
        bangGiaDTO.setChiNhanh(new ChiNhanhDTO());
        bangGiaDTO.setMaBangGia(banggia.getMabanggia());
        bangGiaDTO.setThoiGianBatDau(banggia.getThoigianbatdau());
        bangGiaDTO.setThoiGianKetThuc(banggia.getThoigianketthuc());
        bangGiaDTO.setNoiDung(banggia.getNoidung());
        bangGiaDTO.setTrangThai(banggia.getTrangthai());
        if (banggia.getChinhanh() != null) {
            bangGiaDTO.getChiNhanh().setMaChiNhanh(banggia.getChinhanh().getMachinhanh());
            bangGiaDTO.getChiNhanh().setTenChiNhanh(banggia.getChinhanh().getTenchinhanh());
        }
        return bangGiaDTO;
    }

    // Lay danh sach bang gia
    @GetMapping
    public ResponseEntity<List<BangGiaDTO>> findAll() {
        List<Banggia> list = new ArrayList<>();
        List<BangGiaDTO> dtoList = new ArrayList<>();
        list = bangGiaService.findAll();
        for (Banggia item : list) {
            BangGiaDTO bangGiaDTO = convertToDTO(item);
            dtoList.add(bangGiaDTO);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    // Them bang gia
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody BangGiaDTO bangGiaDTO) {
        Banggia banggia = new Banggia();
        banggia.setThoigianbatdau(bangGiaDTO.getThoiGianBatDau());
        banggia.setThoigianketthuc(bangGiaDTO.getThoiGianKetThuc());
        banggia.setNoidung(bangGiaDTO.getNoiDung());
        banggia.setTrangthai(bangGiaDTO.getTrangThai());
        if (bangGiaDTO.getChiNhanh() != null) {
            banggia.setChinhanh(chiNhanhService.findById(bangGiaDTO.getChiNhanh().getMaChiNhanh()).orElse(null));
        }
        banggia = bangGiaService.save(banggia);
        if (bangGiaService.isExistsById(banggia.getMabanggia())) {
            BangGiaDTO bangGiaDTO1 = convertToDTO(banggia);
            return new ResponseEntity<>(bangGiaDTO1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Thêm thất bại", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BangGiaDTO bangGiaDTO) {
        if (!bangGiaService.isExistsById(bangGiaDTO.getMaBangGia())) {
            return new ResponseEntity<>("Bảng giá không tồn tại", HttpStatus.BAD_REQUEST);
        }
        Banggia banggia = new Banggia();
        banggia.setMabanggia(bangGiaDTO.getMaBangGia());
        banggia.setThoigianbatdau(bangGiaDTO.getThoiGianBatDau());
        banggia.setThoigianketthuc(bangGiaDTO.getThoiGianKetThuc());
        banggia.setNoidung(bangGiaDTO.getNoiDung());
        banggia.setTrangthai(bangGiaDTO.getTrangThai());
        if (bangGiaDTO.getChiNhanh() != null) {
            banggia.setChinhanh(chiNhanhService.findById(bangGiaDTO.getChiNhanh().getMaChiNhanh()).orElse(null));
        }
        banggia = bangGiaService.save(banggia);
        BangGiaDTO bangGiaDTO1 = convertToDTO(banggia);
        return new ResponseEntity<>(bangGiaDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (!bangGiaService.isExistsById(id)) {
            return new ResponseEntity<>("Bảng giá không tồn tại", HttpStatus.BAD_REQUEST);
        }
        bangGiaService.deleteById(id);
        if (!bangGiaService.isExistsById(id)) {
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Xóa thất bại", HttpStatus.BAD_REQUEST);
        }
    }
}
