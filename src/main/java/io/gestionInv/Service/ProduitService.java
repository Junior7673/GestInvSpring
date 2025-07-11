package io.gestionInv.Service;

import io.gestionInv.DTO.ProduitRequestDTO;
import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Exception.RessourceIntrouvableException;
import io.gestionInv.Gateway.Impl.CategorieGatewayInterface;
import io.gestionInv.Gateway.Impl.FournisseurGatewayInterface;
import io.gestionInv.Gateway.Impl.ProduitGatewayInterface;
import io.gestionInv.Mapper.ProduitMapper;
import io.gestionInv.Persistance.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitService implements ProduitServiceInterface{
    private final ProduitGatewayInterface gateway;
    private final CategorieGatewayInterface categorieGateway;
    private final FournisseurGatewayInterface fournisseurGateway;
    private final ProduitMapper mapper;

    @Override
    public ProduitRequestDTO save(ProduitRequestDTO dto) {
        if (dto.getCategorieId() == null || dto.getFournisseurId() == null) {
            throw new IllegalArgumentException("Les IDs de catégorie et fournisseur sont requis.");
        }
        // Vérification de la catégorie
        CategorieJPAEntity categorie = categorieGateway.findById(dto.getCategorieId());
        if (categorie == null) {
            throw new RessourceIntrouvableException("Catégorie avec ID " + dto.getCategorieId() + " introuvable.");
        }
        // Vérification du fournisseur
        FournisseurJPAEntity fournisseur = fournisseurGateway.findById(dto.getFournisseurId());
        if (fournisseur == null) {
            throw new RessourceIntrouvableException("Fournisseur avec ID " + dto.getFournisseurId() + " introuvable.");
        }
        // Mapping du DTO vers entité domaine
        Produit produit = mapper.toDomain(dto);
        // Sauvegarde
        Produit saved = gateway.save(produit, categorie, fournisseur);
        // Retour du DTO avec ID généré
        return mapper.toDTO(saved);
    }



    @Override
    public List<ProduitRequestDTO> liste() {
        return gateway.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduitRequestDTO> produitsEnAlerte() {
        return gateway.findAll().stream()
                .filter(p -> p.getStockprod() < p.getSeuilAlerteprod())
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitRequestDTO getProduit(Long id) {
        Produit produit = gateway.findById(id);
        if (produit == null) {
            throw new RessourceIntrouvableException("Produit avec ID " + id + " introuvable.");
        }
        return mapper.toDTO(produit);    }

    @Override
    public void delete(Long id) {
        Produit exist = gateway.findById(id);
        if (exist == null) {
            throw new RessourceIntrouvableException("Impossible de supprimer : produit avec ID " + id + " introuvable.");
        }
        gateway.delete(id);
    }


}

