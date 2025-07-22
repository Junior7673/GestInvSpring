package io.gestionInv.Mapper;

import io.gestionInv.DTO.SortieRequestDTO;
import io.gestionInv.Domaine.Sortie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@AllArgsConstructor
public class SortieMapper {
    private final ProduitMapper produitMapper;

    public SortieRequestDTO toDTO(Sortie sortie) {
        SortieRequestDTO dto = new SortieRequestDTO();
        dto.setId(sortie.getId());
        dto.setStock(sortie.getStock());
        dto.setDate(sortie.getDate());
        dto.setProduitId(sortie.getProduit().getId());
        dto.setNomprod(sortie.getProduit().getNomprod());

        return dto;
    }

    public Sortie toDomain(SortieRequestDTO dto){
        Sortie sortie = new Sortie();
        sortie.setId(dto.getId());
        sortie.setStock(dto.getStock());
        sortie.setDate(dto.getDate());

        return sortie;
    }
}
