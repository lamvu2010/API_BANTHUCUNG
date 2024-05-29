package ptithcm.centerservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.centerservice.Entity.Ctmuasanpham;
import ptithcm.centerservice.Entity.CtmuasanphamPK;

public interface CtMuaSanPhamRepo extends JpaRepository<Ctmuasanpham,CtmuasanphamPK> {
}
