package io.gestionInv.Domaine;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomprod;
    private double prixprod;
    private int stockprod;
    private int seuilAlerteprod;

    @ManyToOne
    @JoinColumn(name = "categorieId")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "fournisseurId")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit")
    private List<Entree> produitEntrees;

    @OneToMany(mappedBy = "produit")
    private List<Sortie> produitSorties;

    public Produit(Long id, String nomprod, double prixprod, int stockprod, int seuilAlerteprod, Categorie categorie, Fournisseur fournisseur) {
        this.id = id;
        this.nomprod = nomprod;
        this.prixprod = prixprod;
        this.stockprod = stockprod;
        this.seuilAlerteprod = seuilAlerteprod;
        this.categorie = categorie;
        this.fournisseur = fournisseur;
    }


}
