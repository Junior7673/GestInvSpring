package io.gestionInv.Repository;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Persistance.EntreeJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EntreeJPARepository extends JpaRepository<Entree, Long> {
    List<Entree> findByProduit_NomprodContainingIgnoreCase(String term);
    List<Entree> findByDateBetween(LocalDate dateDebut, LocalDate dateFin);
}
