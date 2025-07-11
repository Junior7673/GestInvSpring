package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Persistance.EntreeJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;

import java.util.List;

public interface EntreeGatewayInterface {
    Entree save(Entree categorie, ProduitJPAEntity produit);
    List<Entree> findAll();
    EntreeJPAEntity findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
