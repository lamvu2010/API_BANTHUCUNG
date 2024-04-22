package ptithcm.Api_BanThuCungOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.Api_BanThuCungOnline.Entity.Loaisanpham;
import ptithcm.Api_BanThuCungOnline.Entity.Sanpham;
import ptithcm.Api_BanThuCungOnline.Repositories.SanPhamRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    // Lấy danh sách tất cả sản phẩm
    public List<Sanpham> findAll(){
        List<Sanpham> list = sanPhamRepo.findAll();
        return list;
    }
    //Lay san pham bang id
    public Optional<Sanpham> findById(int id){
        Optional<Sanpham> sanpham = sanPhamRepo.findById(id);
        return sanpham;
    }

    //Lay danh sach cac san pham cung loai san pham
    public List<Sanpham> findByIdLoai(Loaisanpham loaisanpham){
        List<Sanpham> list = sanPhamRepo.findByloaisanpham(loaisanpham);
        return list;
    }
    // Them san pham
    public Sanpham insert(Sanpham sanpham){
        return sanPhamRepo.save(sanpham);
    }
    //

}
