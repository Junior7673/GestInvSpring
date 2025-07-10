package io.gestionInv.DTO;

import lombok.Data;

@Data
public class FournisseurRequestDTO {
    private Long id;
    private String nomfourni;
    private String telephonefourni;
    private String adressefourni;
}
