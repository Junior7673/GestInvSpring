package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.FournisseurJPAEntity;

import java.util.List;

public interface ProduitGatewayInterface {
    Produit save(Produit produit, CategorieJPAEntity categorie, FournisseurJPAEntity fournisseur);
    List<Produit> findProduitsEnAlerte();
    List<Produit> findAll();
    Produit findById(Long id);
    void delete(Long id);
}
