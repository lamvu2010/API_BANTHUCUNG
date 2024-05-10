package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTORequest.BangGiaThuCungRequest;
import ptithcm.Api_BanThuCungOnline.DTOResponse.BangGiaThuCungDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Banggia;
import ptithcm.Api_BanThuCungOnline.Entity.Ctbanggiathucung;
import ptithcm.Api_BanThuCungOnline.Entity.CtbanggiathucungPK;
import ptithcm.Api_BanThuCungOnline.Entity.Thucung;
import ptithcm.Api_BanThuCungOnline.Services.BangGiaService;
import ptithcm.Api_BanThuCungOnline.Services.BangGiaThuCungService;
import ptithcm.Api_BanThuCungOnline.Services.ThuCungService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ct-thu-cung")
public class BangGiaThuCungController {
    @Autowired
    BangGiaThuCungService bangGiaThuCungService;
    @Autowired
    ThuCungService thuCungService;
    @Autowired
    BangGiaService bangGiaService;

    @GetMapping
    public ResponseEntity<?> getChiTietBangGiaThuCung() {
        List<Map<?, ?>> result = bangGiaThuCungService.danhSachThuCungBan();
        if (result.isEmpty()) {
            return new ResponseEntity<>("Không có dữ liệu", HttpStatus.BAD_REQUEST);
        }
        List<BangGiaThuCungDTO> dtoList = new ArrayList<>();
        for (Map<?, ?> item : result) {
            BangGiaThuCungDTO bangGiaThuCungDTO = new BangGiaThuCungDTO();
            if (item.get("MABANGGIA") != null) {
                bangGiaThuCungDTO.setMaBangGia((long) item.get("MABANGGIA"));
                bangGiaThuCungDTO.setThoiGianBatDau((Timestamp) item.get("THOIGIANBATDAU"));
                bangGiaThuCungDTO.setThoiGianKetThuc((Timestamp) item.get("THOIGIANKETTHUC"));
                bangGiaThuCungDTO.setGiaKhuyenMai((BigDecimal) item.get("GIAKM"));
            }
            if (item.get("MACHINHANH") != null) {
                bangGiaThuCungDTO.setMaChiNhanh((int) item.get("MACHINHANH"));
                bangGiaThuCungDTO.setTenChiNhanh((String) item.get("TENCHINHANH"));
            }
            if (item.get("MATHUCUNG") != null) {
                bangGiaThuCungDTO.setMaThuCung((long) item.get("MATHUCUNG"));
                bangGiaThuCungDTO.setTenThuCung((String) item.get("TENTHUCUNG"));
                bangGiaThuCungDTO.setMoTa((String) item.get("MOTA"));
                bangGiaThuCungDTO.setGiaHienTai((BigDecimal) item.get("GIAHIENTAI"));
            }
            if (item.get("MAGIONG") != null) {
                bangGiaThuCungDTO.setMaGiong((int) item.get("MAGIONG"));
                bangGiaThuCungDTO.setTenGiong((String) item.get("TENGIONG"));
            }
            dtoList.add(bangGiaThuCungDTO);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertChiTietBangGiaThuCung(@RequestBody List<BangGiaThuCungRequest> bangGiaThuCungRequests) {
        try {
            for (BangGiaThuCungRequest item : bangGiaThuCungRequests) {
                if (item.getMaBangGia() == 0 || item.getMaThuCung() == 0) {
                    continue;
                }
                CtbanggiathucungPK ctbanggiathucungPK = new CtbanggiathucungPK(item.getMaBangGia(), item.getMaThuCung());
                Ctbanggiathucung ctbanggiathucung = new Ctbanggiathucung();
                ctbanggiathucung.setId(ctbanggiathucungPK);
                ctbanggiathucung.setDongia(item.getDonGia());
                Thucung thucung = thuCungService.findById(ctbanggiathucungPK.getMathucung()).orElse(null);
                Banggia banggia = bangGiaService.findById(ctbanggiathucungPK.getMabanggia()).orElse(null);
                ctbanggiathucung.setThucung(thucung);
                ctbanggiathucung.setBanggia(banggia);
                bangGiaThuCungService.save(ctbanggiathucung);
            }
            return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cập nhật thất bại", HttpStatus.BAD_REQUEST);
        }
    }
}
