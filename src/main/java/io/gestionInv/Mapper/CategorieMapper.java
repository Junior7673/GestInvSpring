package io.gestionInv.Mapper;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Persistance.CategorieJPAEntity;
import org.springframework.stereotype.Component;

@Component
public class CategorieMapper {
    // Domaine → DTO
    public CategorieRequestDTO toDTO(Categorie categorie) {
        CategorieRequestDTO dto = new CategorieRequestDTO();
        dto.setId(categorie.getId());
        dto.setNomcat(categorie.getNomcat());
        dto.setDescriptioncat(categorie.getDescriptioncat());
        return dto;
    }
    // DTO → Domaine
    public Categorie toDomain(CategorieRequestDTO dto) {
        Categorie categorie = new Categorie();
        categorie.setId(dto.getId());
        categorie.setNomcat(dto.getNomcat());
        categorie.setDescriptioncat(dto.getDescriptioncat());
        return categorie;
    }
    // Domaine → JPA Entity
    public CategorieJPAEntity toEntity(Categorie categorie) {
        CategorieJPAEntity entity = new CategorieJPAEntity();
        entity.setId(categorie.getId());
        entity.setNomcat(categorie.getNomcat());
        entity.setDescriptioncat(categorie.getDescriptioncat());
        return entity;
    }

    // JPA Entity → Domaine
    public Categorie toDomain(CategorieJPAEntity entity) {
        Categorie categorie = new Categorie();
        categorie.setId(entity.getId());
        categorie.setNomcat(entity.getNomcat());
        categorie.setDescriptioncat(entity.getDescriptioncat());
        return categorie;
    }
}