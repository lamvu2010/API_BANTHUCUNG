package ptithcm.Api_BanThuCungOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.Api_BanThuCungOnline.Entity.Ctbanggiathucung;
import ptithcm.Api_BanThuCungOnline.Repositories.CtBangGiaThuCungRepo;

import java.util.List;
import java.util.Map;
@Service
public class BangGiaThuCungService {
    @Autowired
    CtBangGiaThuCungRepo ctBangGiaThuCungRepo;
    public List<Map<?,?>> danhSachThuCungBan(){
        return ctBangGiaThuCungRepo.danhSachThuCungBan();
    }

    public Ctbanggiathucung save(Ctbanggiathucung ctbanggiathucung){
        return ctBangGiaThuCungRepo.save(ctbanggiathucung);
    }
}
