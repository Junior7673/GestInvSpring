package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Persistance.SortieJPAEntity;

import java.util.List;

public interface SortieGatewayInterface {
    Sortie save(Sortie sortie, ProduitJPAEntity produit);
    List<Sortie> findAll();
    SortieJPAEntity findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
