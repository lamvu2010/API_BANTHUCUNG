package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptithcm.Api_BanThuCungOnline.Entity.Nhanvien;

public interface NhanVienRepo extends JpaRepository<Nhanvien,String> {
    @Query(value = "SELECT dbo.MANHANVIENMOI()",nativeQuery = true)
    String maNhanVienMoi();
}
