package io.gestionInv.Repository;

import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurJPARepository extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> findByNomfourniContainingIgnoreCase(String term);
}
