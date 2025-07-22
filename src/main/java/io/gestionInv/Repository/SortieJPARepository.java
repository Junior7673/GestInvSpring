package io.gestionInv.Repository;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SortieJPARepository extends JpaRepository<Sortie, Long> {
    List<Sortie> findByProduit_NomprodContainingIgnoreCase(String term);
    List<Sortie> findByDateBetween(LocalDate dateDebut, LocalDate dateFin);
}
