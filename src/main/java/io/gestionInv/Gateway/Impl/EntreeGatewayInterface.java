package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Persistance.EntreeJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;

import java.time.LocalDate;
import java.util.List;

public interface EntreeGatewayInterface {
    Entree save(Entree categorie);
   // Entree save(Entree entree, Produit produit);
    List<Entree> findAll();
    List<Entree> search(String term);
    List<Entree> filterByPeriod(LocalDate date1, LocalDate date2);
    Entree findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
