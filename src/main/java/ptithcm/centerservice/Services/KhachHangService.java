package ptithcm.centerservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.centerservice.Entity.Khachhang;
import ptithcm.centerservice.Repositories.KhachHangRepo;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepo khachHangRepo;
    public Khachhang save(Khachhang khachhang){
        return khachHangRepo.save(khachhang);
    }
}
