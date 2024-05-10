package ptithcm.Api_BanThuCungOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.Api_BanThuCungOnline.Services.BangGiaSanPhamService;

@RestController
@RequestMapping("/ctbanggiasanpham")
public class BangGiaSanPhamController {
    @Autowired
    BangGiaSanPhamService bangGiaSanPhamService;


    // fix lại sp
}
