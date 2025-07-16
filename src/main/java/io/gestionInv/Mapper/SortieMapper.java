package io.gestionInv.Mapper;

import io.gestionInv.DTO.SortieRequestDTO;
import io.gestionInv.DTO.SortieRequestDTO;
import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Persistance.EntreeJPAEntity;
import io.gestionInv.Persistance.SortieJPAEntity;
import io.gestionInv.Persistance.SortieJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@AllArgsConstructor
public class SortieMapper {
    private final ProduitMapper produitMapper;

    public SortieJPAEntity toEntityComplete(Sortie sortie, Produit produit) {
        SortieJPAEntity entity = new SortieJPAEntity();
        entity.setId(sortie.getId());
        entity.setStock(sortie.getStock());
        entity.setDate(sortie.getDate());
        entity.setProduit(produitMapper.basicToEntity(produit));

        return entity;
    }

    public SortieJPAEntity toEntity(Sortie sortie) {
        SortieJPAEntity entity = new SortieJPAEntity();
        entity.setId(sortie.getId());
        entity.setStock(sortie.getStock());
        entity.setDate(sortie.getDate());

        return entity;
    }

    public SortieRequestDTO toDTO(Sortie sortie) {
        SortieRequestDTO dto = new SortieRequestDTO();
        dto.setId(sortie.getId());
        dto.setStock(sortie.getStock());
        dto.setDate(sortie.getDate());
        dto.setProduitId(sortie.getProduit().getId());

        return dto;
    }

    public Sortie toDomain(SortieRequestDTO dto, Produit produit){
        Sortie sortie = new Sortie();
        sortie.setId(dto.getId());
        sortie.setStock(dto.getStock());
        sortie.setDate(dto.getDate());
        sortie.setProduit(produit);

        return sortie;
    }

    public Sortie toDomain(SortieJPAEntity entity){
        Sortie sortie = new Sortie();
        sortie.setId(entity.getId());
        sortie.setStock(entity.getStock());
        sortie.setDate(entity.getDate());
        sortie.setProduit(produitMapper.toDomain(entity.getProduit()));

        return sortie;
    }
}
