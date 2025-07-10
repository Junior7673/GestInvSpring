package io.gestionInv.Persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gestionInv.Domaine.Fournisseur;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Fournisseur")
public class FournisseurJPAEntity extends Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nomfourni;


    private String telephonefourni;


    private String adressefourni;

    @JsonIgnore
    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProduitJPAEntity> produitsJPAEntity = new ArrayList<>();

    public FournisseurJPAEntity(Long id, String nomfourni, String telephonefourni, String adressefourni) {
    }
}

