package ptithcm.centerservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ptithcm.centerservice.Entity.Ctmuathucung;
import ptithcm.centerservice.Entity.CtmuathucungPK;

public interface CtMuaThuCungRepo extends JpaRepository<Ctmuathucung,CtmuathucungPK> {
}
