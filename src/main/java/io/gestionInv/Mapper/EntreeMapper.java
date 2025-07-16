package io.gestionInv.Mapper;

import io.gestionInv.DTO.EntreeRequestDTO;
import io.gestionInv.Domaine.Entree;
import io.gestionInv.Persistance.EntreeJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@AllArgsConstructor
public class EntreeMapper {
    private final ProduitMapper produitMapper;

    public EntreeJPAEntity toEntityComplete(Entree entree, ProduitJPAEntity produit) {
        EntreeJPAEntity entity = new EntreeJPAEntity();
        entity.setId(entree.getId());
        entity.setStock(entree.getStock());
        entity.setDate(entree.getDate());
        entity.setProduit(produit);

        return entity;
    }

    public ProduitJPAEntity toEntity(Entree entree) {
        EntreeJPAEntity entity = new EntreeJPAEntity();
        entity.setId(entree.getId());
        entity.setStock(entree.getStock());
        entity.setDate(entree.getDate());

        return entity;
    }

    public EntreeRequestDTO toDTO(Entree entree) {
        EntreeRequestDTO dto = new EntreeRequestDTO();
        dto.setId(entree.getId());
        dto.setStock(entree.getStock());
        dto.setDate(entree.getDate());
        dto.setProduitId(entree.getProduit().getId());

        return dto;
    }

    public Entree toDomain(EntreeRequestDTO dto){
        Entree entree = new Entree();
        entree.setId(dto.getId());
        entree.setStock(dto.getStock());
        entree.setDate(dto.getDate());

        return entree;
    }

    public Entree toDomain(EntreeJPAEntity entity){
        Entree entree = new Entree();
        entree.setId(entity.getId());
        entree.setStock(entity.getStock());
        entree.setDate(entity.getDate());
        //entree.setProduit(entity.getProduit());
        // 🔁 Conversion du ProduitJPAEntity → Produit (via mapper)
        entree.setProduit(produitMapper.toDomain(entity.getProduit()));

        return entree;
    }
}
