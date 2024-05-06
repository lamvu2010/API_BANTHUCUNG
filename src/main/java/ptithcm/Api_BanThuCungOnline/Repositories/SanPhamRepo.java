package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.Api_BanThuCungOnline.Entity.Loaisanpham;
import ptithcm.Api_BanThuCungOnline.Entity.Sanpham;

import java.util.List;

public interface SanPhamRepo extends JpaRepository<Sanpham,Long> {
    List<Sanpham> findByloaisanpham(Loaisanpham loaisanpham);
}
