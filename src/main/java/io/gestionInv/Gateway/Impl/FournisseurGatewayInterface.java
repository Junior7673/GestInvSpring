package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Persistance.FournisseurJPAEntity;

import java.util.List;

public interface FournisseurGatewayInterface {
    Fournisseur save(Fournisseur fournisseur);
    List<Fournisseur> findAll();
    List<Fournisseur> search(String term);
    Fournisseur findById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}
