package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.Api_BanThuCungOnline.Entity.Nhanvien;

public interface NhanVienRepo extends JpaRepository<Nhanvien,String> {
}