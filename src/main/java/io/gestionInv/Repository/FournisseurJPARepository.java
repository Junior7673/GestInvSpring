package io.gestionInv.Repository;

import io.gestionInv.Persistance.FournisseurJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurJPARepository extends JpaRepository<FournisseurJPAEntity, Long> {
    List<FournisseurJPAEntity> findByNomfourniContainingIgnoreCase(String term);
}
