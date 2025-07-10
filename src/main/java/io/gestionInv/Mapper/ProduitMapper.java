package io.gestionInv.Mapper;

import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.DTO.ProduitRequestDTO;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component

@AllArgsConstructor
public class ProduitMapper {
    private final CategorieMapper categorieMapper;
    private final FournisseurMapper fournisseurMapper;


    public Produit toDomain(ProduitJPAEntity entity) {
        Produit produit = new Produit();
        produit.setId(entity.getId());
        produit.setNomprod(entity.getNomprod());
        produit.setPrixprod(entity.getPrixprod());
        produit.setStockprod(entity.getStockprod());
        produit.setSeuilAlerteprod(entity.getSeuilAlerteprod());

        if (entity.getCategorie() != null) {
            //produit.setCategorie((CategorieJPAEntity) categorieMapper.toDomain(entity.getCategorie()));
            produit.setCategorie(toCategorieDomain(entity.getCategorie()));
        }

        if (entity.getFournisseur() != null) {
           // produit.setFournisseur((FournisseurJPAEntity) fournisseurMapper.toDomain(entity.getFournisseur()));
            produit.setFournisseur(toFournisseurDomain(entity.getFournisseur()));
        }

        return produit;
    }

    public ProduitJPAEntity toEntity(Produit produit) {
        return new ProduitJPAEntity(
                produit.getId(),
                produit.getNomprod(),
                produit.getPrixprod(),
                produit.getStockprod(),
                produit.getSeuilAlerteprod(),
                toCategorieEntity(produit.getCategorie()),
                toFournisseurEntity(produit.getFournisseur())
        );
    }

    // --- Conversions Categorie
    private CategorieJPAEntity toCategorieEntity(Categorie cat) {
        if (cat == null) return null;
        return new CategorieJPAEntity(cat.getId(), cat.getNomcat(), cat.getDescriptioncat());
    }

    private Categorie toCategorieDomain(CategorieJPAEntity entity) {
        if (entity == null) return null;
        return new Categorie(entity.getId(), entity.getNomcat(), entity.getDescriptioncat());
    }

    // --- Conversions Fournisseur
    private FournisseurJPAEntity toFournisseurEntity(Fournisseur four) {
        if (four == null) return null;
        return new FournisseurJPAEntity(four.getId(), four.getNomfourni(), four.getTelephonefourni(), four.getAdressefourni());
    }

    private Fournisseur toFournisseurDomain(FournisseurJPAEntity entity) {
        if (entity == null) return null;
        return new Fournisseur(entity.getId(), entity.getNomfourni(), entity.getTelephonefourni(), entity.getAdressefourni());
    }


    public Produit toDomain(ProduitRequestDTO dto, Categorie categorie, Fournisseur fournisseur) {
        Produit produit = new Produit();
        produit.setId(dto.getId());
        produit.setNomprod(dto.getNomprod());
        produit.setStockprod(dto.getStockprod());
        produit.setPrixprod(dto.getPrixprod());
        produit.setSeuilAlerteprod(dto.getSeuilAlerteprod());
        produit.setCategorie(categorie);
        produit.setFournisseur(fournisseur);
        return produit;
    }


    public ProduitRequestDTO toDTO(Produit produit) {
        ProduitRequestDTO dto = new ProduitRequestDTO();
        dto.setId(produit.getId());
        dto.setNomprod(produit.getNomprod());
        dto.setPrixprod(produit.getPrixprod());
        dto.setStockprod(produit.getStockprod());
        dto.setSeuilAlerteprod(produit.getSeuilAlerteprod());
        dto.setCategorieId(produit.getCategorie() != null ? produit.getCategorie().getId() : null);
        dto.setFournisseurId(produit.getFournisseur() != null ? produit.getFournisseur().getId() : null);
        return dto;
    }

}
