package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptithcm.Api_BanThuCungOnline.Entity.Ctbanggiasanpham;
import ptithcm.Api_BanThuCungOnline.Entity.CtbanggiasanphamPK;

import java.util.List;
import java.util.Map;

public interface CtBangGiaSanPhamRepo extends JpaRepository<Ctbanggiasanpham, CtbanggiasanphamPK> {
    @Query(value = "execute DANHSACHTHUCUNGBAN;",nativeQuery = true)
    List<Map<?,?>> danhSachThuCungBan();
}
