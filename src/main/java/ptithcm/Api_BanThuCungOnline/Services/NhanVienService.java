package ptithcm.Api_BanThuCungOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.Api_BanThuCungOnline.Entity.Nhanvien;
import ptithcm.Api_BanThuCungOnline.Repositories.NhanVienRepo;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    NhanVienRepo nhanVienRepo;

    public List<Nhanvien> findAll(){
        return nhanVienRepo.findAll();
    }

    public Optional<Nhanvien> findById(String id){
        return nhanVienRepo.findById(id);
    }

    public Nhanvien save(Nhanvien nhanvien){
        return nhanVienRepo.save(nhanvien);
    }

    public void delete(Nhanvien nhanvien){
        nhanVienRepo.delete(nhanvien);
    }
    public void deleteById(String id){
        nhanVienRepo.deleteById(id);
    }

    public boolean isExistsById(String id){
        return nhanVienRepo.existsById(id);
    }
    public String maNhanVienMoi(){
        return nhanVienRepo.maNhanVienMoi();
    }
}
