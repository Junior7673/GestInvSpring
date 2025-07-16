package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Persistance.EntreeJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;

import java.util.List;

public interface EntreeGatewayInterface {
    Entree save(Entree categorie, Produit produit);
   // Entree save(Entree entree, Produit produit);
    List<Entree> findAll();
    Entree findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
