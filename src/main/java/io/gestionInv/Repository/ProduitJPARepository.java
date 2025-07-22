package io.gestionInv.Repository;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.Persistance.ProduitJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitJPARepository extends JpaRepository<Produit, Long>{
    List<Produit> findByNomprodContainingIgnoreCase(String term);
    List<Produit> findByCategorieId(Long categorieId);
}
