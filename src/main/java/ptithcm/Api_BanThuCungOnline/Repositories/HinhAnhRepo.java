package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.Api_BanThuCungOnline.Entity.Hinhanh;

public interface HinhAnhRepo extends JpaRepository<Hinhanh,Long> {
    Hinhanh findByTenduynhat(String tenduynhat);
}
