package ptithcm.Api_BanThuCungOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.Api_BanThuCungOnline.Entity.Thucung;
import ptithcm.Api_BanThuCungOnline.Repositories.ThuCungRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ThuCungService {
    @Autowired
    ThuCungRepo thuCungRepo;

    // Lay danh sach thu cung
    public List<Thucung> findAll(){
        return thuCungRepo.findAll();
    }

    // Lay thu cung bang id
    public Optional<Thucung> findById(long id){
        return thuCungRepo.findById(id);
    }

    // Them cap nhat thuc cung
    public Thucung save(Thucung thucung){
        return thuCungRepo.save(thucung);
    }
    //Xoa thu cung
    public void delete(Thucung thucung){
        thuCungRepo.delete(thucung);
    }

    // Kiem tra ton tai
    public boolean isExistsById(long id){
        return thuCungRepo.existsById(id);
    }
}
