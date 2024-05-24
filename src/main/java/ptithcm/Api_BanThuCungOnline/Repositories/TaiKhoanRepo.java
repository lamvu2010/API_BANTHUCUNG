package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.Api_BanThuCungOnline.Entity.Taikhoan;

import java.util.List;
import java.util.Optional;

public interface TaiKhoanRepo extends JpaRepository<Taikhoan,String> {

    Taikhoan findBytendangnhap(String tendangnhap);
    List<Taikhoan> findByquyen(Boolean quyen);

}
