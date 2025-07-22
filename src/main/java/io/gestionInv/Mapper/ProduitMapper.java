package io.gestionInv.Mapper;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.DTO.ProduitRequestDTO;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component

@AllArgsConstructor
public class ProduitMapper {

    public ProduitRequestDTO toDTO(Produit produit) {
        ProduitRequestDTO dto = new ProduitRequestDTO();
        dto.setId(produit.getId());
        dto.setNomprod(produit.getNomprod());
        dto.setPrixprod(produit.getPrixprod());
        dto.setStockprod(produit.getStockprod());
        dto.setSeuilAlerteprod(produit.getSeuilAlerteprod());
        dto.setCategorieId(produit.getCategorie() != null ? produit.getCategorie().getId() : null);
        dto.setFournisseurId(produit.getFournisseur() != null ? produit.getFournisseur().getId() : null);
        dto.setNomcat(produit.getCategorie() != null ? produit.getCategorie().getNomcat() : null);
        return dto;
    }

    public Produit toDomain(ProduitRequestDTO dto){
        Produit produit = new Produit();
        produit.setId(dto.getId());
        produit.setNomprod(dto.getNomprod());
        produit.setPrixprod(dto.getPrixprod());
        produit.setStockprod(dto.getStockprod());
        produit.setSeuilAlerteprod(dto.getSeuilAlerteprod());

        return produit;
    }

}
