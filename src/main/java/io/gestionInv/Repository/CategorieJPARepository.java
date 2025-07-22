package io.gestionInv.Repository;

import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Persistance.CategorieJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategorieJPARepository extends JpaRepository<Categorie,Long> {
    List<Categorie> findByNomcatContainingIgnoreCase(String term);
}

