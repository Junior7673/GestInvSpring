package io.gestionInv.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurJPARepository extends JpaRepository<FournisseurJPAEntity, Long> {
    List<FournisseurJPAEntity> findByNomfourniContainingIgnoreCase(String term);
}
