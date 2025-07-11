package io.gestionInv.DTO;

import io.gestionInv.Domaine.Produit;
import lombok.Data;

import java.sql.Date;

@Data
public class SortieRequestDTO {
    private Long id;
    private Long produitId;
    private int stock;
    private Date date;
}
