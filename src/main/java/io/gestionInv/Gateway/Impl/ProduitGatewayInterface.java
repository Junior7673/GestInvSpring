package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;

import java.util.List;

public interface ProduitGatewayInterface {
    Produit save(Produit produit);
    List<Produit> findProduitsEnAlerte();
    List<Produit> findAll();
    List<Produit> search(String term);
    List<Produit> filterByCategory(Long id);
    Produit findById(Long id);
    void delete(Long id);
}
