package io.gestionInv.Domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
public class Entree {
    private Long id;
    private Produit produit;
    private int stock;
    private Date date;

    public Entree() {

    }
}
