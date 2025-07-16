package io.gestionInv.Service;

import io.gestionInv.DTO.EntreeRequestDTO;
import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Exception.RessourceIntrouvableException;
import io.gestionInv.Gateway.Impl.EntreeGatewayInterface;
import io.gestionInv.Gateway.Impl.ProduitGatewayInterface;
import io.gestionInv.Mapper.EntreeMapper;
import io.gestionInv.Mapper.ProduitMapper;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Repository.ProduitJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntreeService implements EntreeServiceInterface{
    private final EntreeGatewayInterface gateway;
    private final ProduitGatewayInterface produitGateway;
    private final EntreeMapper mapper;
    private final ProduitMapper produitMapper;
    private final ProduitService produitService;

    @Override
    public EntreeRequestDTO save(EntreeRequestDTO dto) {
        if (dto.getProduitId() == null) {
            throw new IllegalArgumentException("L'ID de produit est requis.");
        }

        // Vérification du produit
        Produit produit = produitGateway.findById(dto.getProduitId());
        if (produit == null) {
            throw new RessourceIntrouvableException("Produit avec ID " + dto.getProduitId() + " introuvable.");
        }
        // Mapping du DTO vers entité domaine
        Entree entree = mapper.toDomain(dto);
        // Sauvegarde
        Entree saved = gateway.save(entree, produit);

        int reste = produit.getStockprod() + dto.getStock();
        produit.setStockprod(reste);
        produitService.save(produitMapper.toDTO(produit));

        // Retour du DTO avec ID généré
        return mapper.toDTO(saved);
    }

    @Override
    public List<EntreeRequestDTO> getAll() {
        return gateway.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntreeRequestDTO getById(Long id) {
        Entree entree = gateway.findById(id);
        if (entree == null) {
            throw new RessourceIntrouvableException("Entée avec ID " + id + " introuvable.");
        }
        return mapper.toDTO(entree);
    }

    @Override
    public void delete(Long id) {
        Entree exist = gateway.findById(id);
        if (exist == null) {
            throw new RessourceIntrouvableException("Entrée à supprimer introuvable avec ID " + id);
        }
        gateway.delete(id);
    }

}
