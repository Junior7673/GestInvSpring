package io.gestionInv.Repository;

import io.gestionInv.Persistance.ProduitJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitJPARepository extends JpaRepository<ProduitJPAEntity, Long>{
    List<ProduitJPAEntity> findByNomprodContainingIgnoreCase(String term);
}
