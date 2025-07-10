package io.gestionInv.DTO;

import lombok.Data;

@Data
public class CategorieRequestDTO {
    private Long id;
    private String nomcat;
    private String descriptioncat;
}
