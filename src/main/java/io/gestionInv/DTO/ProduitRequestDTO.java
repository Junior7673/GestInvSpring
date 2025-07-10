package io.gestionInv.DTO;

import lombok.*;


@Data
public class ProduitRequestDTO {
    private Long id;
    private String nomprod;
    private double prixprod;
    private int stockprod;
    private int seuilAlerteprod;
    private Long categorieId;
    private Long fournisseurId;


    /*public ProduitRequestDTO(String nomprod, double prixprod, int stockprod, int seuilAlerteprod, Long aLong, Long aLong1) {
    }

    public ProduitRequestDTO() {

    }*/
}
