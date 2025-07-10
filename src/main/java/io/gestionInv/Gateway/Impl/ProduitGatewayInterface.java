package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Produit;

import java.util.List;

public interface ProduitGatewayInterface {
    Produit save(Produit produit);
    List<Produit> findProduitsEnAlerte();
    List<Produit> findAll();
    Produit findById(Long id);
    void delete(Long id);
}
