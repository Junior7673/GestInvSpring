package io.gestionInv.Persistance;

import io.gestionInv.Domaine.Produit;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Produit")
public class ProduitJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomprod;

    private double prixprod;

    private int stockprod;

    private int seuilAlerteprod;

    @ManyToOne
    @JoinColumn(name = "categorieId")
    private CategorieJPAEntity categorie;

    @ManyToOne
    @JoinColumn(name = "fournisseurId")
    private FournisseurJPAEntity fournisseur;

}
