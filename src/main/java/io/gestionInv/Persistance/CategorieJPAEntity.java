package io.gestionInv.Persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gestionInv.Domaine.Categorie;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="Categorie")
public class CategorieJPAEntity extends Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomcat;

    private String descriptioncat;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<ProduitJPAEntity> produitsJPAEntity = new ArrayList<>();


    public CategorieJPAEntity(Long id, String nomcat, String descriptioncat) {
    }
}
