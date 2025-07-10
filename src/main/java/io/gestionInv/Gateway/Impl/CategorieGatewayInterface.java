package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Categorie;

import java.util.List;

public interface CategorieGatewayInterface {
    Categorie save(Categorie categorie);
    List<Categorie> findAll();
    Categorie findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
