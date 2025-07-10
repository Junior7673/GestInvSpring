package io.gestionInv.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategorieJPARepository extends JpaRepository<CategorieJPAEntity,Long> {
    List<CategorieJPAEntity> findByNomcatContainingIgnoreCase(String term);
}

