package io.gestionInv.Domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomfourni;
    private String telephonefourni;
    private String adressefourni;

    @JsonIgnore
    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produit> produits;

    public Fournisseur(Long id, String nomfourni, String telephonefourni, String adressefourni) {
        this.id = id;
        this.nomfourni = nomfourni;
        this.telephonefourni = telephonefourni;
        this.adressefourni = adressefourni;
    }
}
