package io.gestionInv.Domaine;

import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Produit extends ProduitJPAEntity {
    private Long id;
    private String nomprod;
    private double prixprod;
    private int stockprod;
    private int seuilAlerteprod;
    private Categorie categorie;
    private Fournisseur fournisseur;

    public Produit() {

    }

   /* public Produit(Object o, String clavier, double v, int i, int i1, Categorie cat, Fournisseur four) {
    }

    public void setCategorie(Categorie domain) {
    }

    public void setFournisseur(Fournisseur domain) {
    }*/
}
