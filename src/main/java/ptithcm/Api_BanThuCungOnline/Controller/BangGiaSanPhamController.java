package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptithcm.Api_BanThuCungOnline.DTORequest.BangGiaSanPhamRequest;
import ptithcm.Api_BanThuCungOnline.DTOResponse.BangGiaSanPhamDTO;
import ptithcm.Api_BanThuCungOnline.Entity.Banggia;
import ptithcm.Api_BanThuCungOnline.Entity.Ctbanggiasanpham;
import ptithcm.Api_BanThuCungOnline.Entity.CtbanggiasanphamPK;
import ptithcm.Api_BanThuCungOnline.Entity.Sanpham;
import ptithcm.Api_BanThuCungOnline.Services.BangGiaSanPhamService;
import ptithcm.Api_BanThuCungOnline.Services.BangGiaService;
import ptithcm.Api_BanThuCungOnline.Services.SanPhamService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ct-san-pham")
public class BangGiaSanPhamController {
    @Autowired
    BangGiaSanPhamService bangGiaSanPhamService;
    @Autowired
    BangGiaService bangGiaService;
    @Autowired
    SanPhamService sanPhamService;

    // Lay danh sach san pham ban
    @GetMapping
    public ResponseEntity<?> getDanhSachSanPhamBan() {
        List<Map<?, ?>> list = bangGiaSanPhamService.danhSachSanPhamBan();
        List<BangGiaSanPhamDTO> dtoList = new ArrayList<>();
        if (list.isEmpty()) {
            return new ResponseEntity<>("Không có dữ liệu", HttpStatus.BAD_REQUEST);
        }
        for (Map<?, ?> item : list) {
            BangGiaSanPhamDTO bangGiaSanPhamDTO = new BangGiaSanPhamDTO();
            if (item.get("MASANPHAM") != null) {
                bangGiaSanPhamDTO.setMaSanPham((long) item.get("MASANPHAM"));
                bangGiaSanPhamDTO.setTenSanPham((String) item.get("TENSANPHAM"));
                bangGiaSanPhamDTO.setGiaHienTai((BigDecimal) item.get("GIAHIENTAI"));
                bangGiaSanPhamDTO.setSoLuongTon((long) item.get("SOLUONGTON"));
            }
            if (item.get("MALOAISANPHAM") != null) {
                bangGiaSanPhamDTO.setMaLoaiSanPham((int) item.get("MALOAISANPHAM"));
                bangGiaSanPhamDTO.setTenLoaiSanPham((String) item.get("TENLOAISANPHAM"));
            }
            if (item.get("MABANGGIA") != null) {
                bangGiaSanPhamDTO.setMaBangGia((long) item.get("MABANGGIA"));
                bangGiaSanPhamDTO.setThoiGianBatDau((Timestamp) item.get("THOIGIANBATDAU"));
                bangGiaSanPhamDTO.setThoiGianKetThuc((Timestamp) item.get("THOIGIANKETTHUC"));
                bangGiaSanPhamDTO.setGiaKhuyenMai((BigDecimal) item.get("GIAKM"));
            }
            if (item.get("MACHINHANH") != null) {
                bangGiaSanPhamDTO.setMaChiNhanh((int) item.get("MACHINHANH"));
                bangGiaSanPhamDTO.setTenChiNhanh((String) item.get("TENCHINHANH"));
            }
            dtoList.add(bangGiaSanPhamDTO);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> update(@RequestBody List<BangGiaSanPhamRequest> bangGiaSanPhamRequests) {
        try {
            for (BangGiaSanPhamRequest item : bangGiaSanPhamRequests) {
                if (item.getMaBangGia() == 0 || item.getMaSanPham() == 0) {
                    continue;
                }
                CtbanggiasanphamPK ctbanggiasanphamPK = new CtbanggiasanphamPK(item.getMaBangGia(), item.getMaSanPham());
                Ctbanggiasanpham ctbanggiasanpham = new Ctbanggiasanpham();
                ctbanggiasanpham.setId(ctbanggiasanphamPK);
                ctbanggiasanpham.setDongia(item.getDonGia());
                Banggia banggia = bangGiaService.findById(item.getMaBangGia()).orElse(null);
                Sanpham sanpham = sanPhamService.findById(item.getMaSanPham()).orElse(null);
                ctbanggiasanpham.setBanggia(banggia);
                ctbanggiasanpham.setSanpham(sanpham);
                bangGiaSanPhamService.save(ctbanggiasanpham);
            }
            return new ResponseEntity<>("Cập nhật thành công",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cập nhật thất bại", HttpStatus.BAD_REQUEST);
        }
    }
}
