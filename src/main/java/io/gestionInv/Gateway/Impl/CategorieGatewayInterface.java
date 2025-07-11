package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Persistance.CategorieJPAEntity;

import java.util.List;

public interface CategorieGatewayInterface {
    Categorie save(Categorie categorie);
    List<Categorie> findAll();
    CategorieJPAEntity findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
