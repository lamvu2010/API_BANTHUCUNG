package ptithcm.Api_BanThuCungOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.Api_BanThuCungOnline.Entity.Banggia;
import ptithcm.Api_BanThuCungOnline.Repositories.BangGiaRepo;

import java.util.List;

@Service
public class BangGiaService {
    @Autowired
    BangGiaRepo bangGiaRepo;

    public Banggia save(Banggia banggia){
        return bangGiaRepo.save(banggia);
    }
    public List<Banggia> findAll(){
        return bangGiaRepo.findAll();
    }
    public void delete(Banggia banggia){
        bangGiaRepo.delete(banggia);
    }
    public void deleteById(long id){
        bangGiaRepo.deleteById(id);
    }
    public boolean isExistsById(long id){
        return bangGiaRepo.existsById(id);
    }
}
