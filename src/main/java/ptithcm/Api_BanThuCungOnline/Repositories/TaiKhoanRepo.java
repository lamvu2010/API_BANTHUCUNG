package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.Api_BanThuCungOnline.Entity.Taikhoan;

public interface TaiKhoanRepo extends JpaRepository<Taikhoan,String> {
}