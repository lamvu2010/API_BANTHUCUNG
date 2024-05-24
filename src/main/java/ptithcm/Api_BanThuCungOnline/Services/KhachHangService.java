package ptithcm.Api_BanThuCungOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.Api_BanThuCungOnline.Entity.Khachhang;
import ptithcm.Api_BanThuCungOnline.Repositories.KhachHangRepo;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepo khachHangRepo;
    public Khachhang save(Khachhang khachhang){
        return khachHangRepo.save(khachhang);
    }
}
