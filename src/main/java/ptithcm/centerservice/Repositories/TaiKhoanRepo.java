package ptithcm.centerservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.centerservice.Entity.Taikhoan;

import java.util.List;
import java.util.Optional;

public interface TaiKhoanRepo extends JpaRepository<Taikhoan,String> {

    Taikhoan findBytendangnhap(String tendangnhap);
    List<Taikhoan> findByquyen(Boolean quyen);

}
