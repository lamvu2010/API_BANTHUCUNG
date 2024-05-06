package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.Api_BanThuCungOnline.Entity.Khachhang;

public interface KhachHangRepo extends JpaRepository<Khachhang,String> {
}
