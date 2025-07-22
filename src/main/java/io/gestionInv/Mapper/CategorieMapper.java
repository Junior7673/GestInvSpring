package io.gestionInv.Mapper;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.Domaine.Categorie;
import org.springframework.stereotype.Component;

@Component
public class CategorieMapper {

    public CategorieRequestDTO toDTO(Categorie categorie) {
        CategorieRequestDTO dto = new CategorieRequestDTO();
        dto.setId(categorie.getId());
        dto.setNomcat(categorie.getNomcat());
        dto.setDescriptioncat(categorie.getDescriptioncat());
        return dto;
    }

    public Categorie toDomain(CategorieRequestDTO dto) {
        Categorie categorie = new Categorie();
        categorie.setId(dto.getId());
        categorie.setNomcat(dto.getNomcat());
        categorie.setDescriptioncat(dto.getDescriptioncat());
        return categorie;
    }

}