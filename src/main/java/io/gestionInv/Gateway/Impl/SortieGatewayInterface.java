package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Persistance.SortieJPAEntity;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface SortieGatewayInterface {
    Sortie save(Sortie sortie);
    List<Sortie> findAll();
    List<Sortie> search(String term);
    List<Sortie> filterByPeriod(LocalDate date1, LocalDate date2);
    Sortie findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
