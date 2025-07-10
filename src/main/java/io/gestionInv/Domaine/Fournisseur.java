package io.gestionInv.Domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Fournisseur {
    private Long id;
    private String nomfourni;
    private String telephonefourni;
    private String adressefourni;

    public Fournisseur() {

    }
}
