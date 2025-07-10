package io.gestionInv.Domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Categorie {
    private Long id;
    private String nomcat;
    private String descriptioncat;

    public Categorie() {

    }
}
