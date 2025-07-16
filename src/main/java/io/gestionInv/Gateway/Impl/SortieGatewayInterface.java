package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Persistance.SortieJPAEntity;

import java.util.List;

public interface SortieGatewayInterface {
    Sortie save(Sortie sortie, Produit produit);
    List<Sortie> findAll();
    Sortie findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
