package io.gestionInv.Mapper;

import io.gestionInv.DTO.EntreeRequestDTO;
import io.gestionInv.Domaine.Entree;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@AllArgsConstructor
public class EntreeMapper {
    private final ProduitMapper produitMapper;
    private final CategorieMapper categorieMapper;
    private final FournisseurMapper fournisseurMapper;

    public EntreeRequestDTO toDTO(Entree entree) {
        EntreeRequestDTO dto = new EntreeRequestDTO();
        dto.setId(entree.getId());
        dto.setStock(entree.getStock());
        dto.setDate(entree.getDate());
        dto.setProduitId(entree.getProduit().getId());
        dto.setNomprod(entree.getProduit().getNomprod());

        return dto;
    }

    public Entree toDomain(EntreeRequestDTO dto){
        Entree entree = new Entree();
        entree.setId(dto.getId());
        entree.setStock(dto.getStock());
        entree.setDate(dto.getDate());

        return entree;
    }
}
