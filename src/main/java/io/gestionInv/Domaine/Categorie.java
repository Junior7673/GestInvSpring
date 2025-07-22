package io.gestionInv.Domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gestionInv.Persistance.ProduitJPAEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomcat;
    private String descriptioncat;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

    public Categorie(Long id, String nomcat, String descriptioncat) {
        this.id = id;
        this.nomcat = nomcat;
        this.descriptioncat = descriptioncat;
    }
}
