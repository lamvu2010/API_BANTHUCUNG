package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.Api_BanThuCungOnline.DTOResponse.ChiTietBangGiaSanPhamDTO;
import ptithcm.Api_BanThuCungOnline.Services.ChiTietBangGiaSanPhamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ctbanggiasanpham")
public class ChiTietBangGiaSanPhamController {
    @Autowired
    ChiTietBangGiaSanPhamService chiTietBangGiaSanPhamService;

    @GetMapping
    public ResponseEntity<List<Map<?,?>>> getChiTietBangGiaSanPham(){
        List<ChiTietBangGiaSanPhamDTO> list = new ArrayList<>();
        List<Map<?,?>> result = chiTietBangGiaSanPhamService.danhSachThuCungBan();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    // fix lại sp
}
