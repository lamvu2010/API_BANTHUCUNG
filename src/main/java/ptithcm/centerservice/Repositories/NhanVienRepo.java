package ptithcm.centerservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptithcm.centerservice.Entity.Nhanvien;

public interface NhanVienRepo extends JpaRepository<Nhanvien,String> {
    @Query(value = "SELECT dbo.MANHANVIENMOI()",nativeQuery = true)
    String maNhanVienMoi();
}
