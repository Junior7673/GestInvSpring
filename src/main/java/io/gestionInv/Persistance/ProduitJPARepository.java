package io.gestionInv.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitJPARepository extends JpaRepository<ProduitJPAEntity, Long>{
    List<ProduitJPAEntity> findByNomprodContainingIgnoreCase(String term);
}
