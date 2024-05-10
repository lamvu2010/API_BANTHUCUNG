package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptithcm.Api_BanThuCungOnline.Entity.Ctbanggiathucung;
import ptithcm.Api_BanThuCungOnline.Entity.CtbanggiathucungPK;

import java.util.List;
import java.util.Map;

public interface CtBangGiaThuCungRepo extends JpaRepository<Ctbanggiathucung, CtbanggiathucungPK> {
    @Query(value = "execute DANHSACHTHUCUNGBAN;",nativeQuery = true)
    List<Map<?,?>> danhSachThuCungBan();
}
