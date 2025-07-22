package io.gestionInv.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class EntreeRequestDTO {
    private Long id;
    private Long produitId;
    private String nomprod;
    private int stock;
    private Date date;
}
