package ptithcm.Api_BanThuCungOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.Api_BanThuCungOnline.Entity.Thucung;

public interface ThuCungRepo extends JpaRepository<Thucung,Long> {
}
