package io.gestionInv.Repository;

import io.gestionInv.Persistance.CategorieJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategorieJPARepository extends JpaRepository<CategorieJPAEntity,Long> {
    List<CategorieJPAEntity> findByNomcatContainingIgnoreCase(String term);
}

