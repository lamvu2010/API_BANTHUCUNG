package ptithcm.Api_BanThuCungOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.Api_BanThuCungOnline.Entity.Ctbanggiasanpham;
import ptithcm.Api_BanThuCungOnline.Entity.CtbanggiasanphamPK;
import ptithcm.Api_BanThuCungOnline.Repositories.CtBangGiaSanPhamRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BangGiaSanPhamService {
    @Autowired
    CtBangGiaSanPhamRepo ctBangGiaSanPhamRepo;
    // Lay danh sach chi tiet bang gia
    public List<Ctbanggiasanpham> findAll(){
        return ctBangGiaSanPhamRepo.findAll();
    }
    // Lay chi tiet bang gia dua vao id
    public Optional<Ctbanggiasanpham> findById(CtbanggiasanphamPK ctbanggiasanphamPK){
        return ctBangGiaSanPhamRepo.findById(ctbanggiasanphamPK);
    }
    // Them cap nhat san pham
    public Ctbanggiasanpham save(Ctbanggiasanpham ctbanggiasanpham){
        return ctBangGiaSanPhamRepo.save(ctbanggiasanpham);
    }
    // Xoa bang gia san pham
    public void delete(Ctbanggiasanpham ctbanggiasanpham){
        ctBangGiaSanPhamRepo.delete(ctbanggiasanpham);
    }
    // Kiem tra chi tiet bang gia san pham co ton tai
    public boolean existsById(CtbanggiasanphamPK ctbanggiasanphamPK){
        return ctBangGiaSanPhamRepo.existsById(ctbanggiasanphamPK);
    }
    // Lay danh sach chi tiet bang gia san pham

}
