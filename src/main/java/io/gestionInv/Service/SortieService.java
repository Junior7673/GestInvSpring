package io.gestionInv.Service;

import io.gestionInv.DTO.SortieRequestDTO;
import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Exception.RessourceIntrouvableException;
import io.gestionInv.Gateway.Impl.ProduitGatewayInterface;
import io.gestionInv.Gateway.Impl.SortieGatewayInterface;
import io.gestionInv.Mapper.ProduitMapper;
import io.gestionInv.Mapper.SortieMapper;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Persistance.ProduitJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SortieService implements SortieServiceInterface{
    private final SortieGatewayInterface gateway;
    private final ProduitGatewayInterface produitGateway;
    private final SortieMapper mapper;
    private final ProduitJPARepository produitRepo;
    private final ProduitMapper produitMapper;

    @Override
    public SortieRequestDTO save(SortieRequestDTO dto) {
        if (dto.getProduitId() == null) {
            throw new IllegalArgumentException("L'ID de produit est requis.");
        }

        // Vérification du produit
        ProduitJPAEntity produit = produitGateway.findById(dto.getProduitId());
        if (produit == null) {
            throw new RessourceIntrouvableException("Produit avec ID " + dto.getProduitId() + " introuvable.");
        }
        // Mapping du DTO vers entité domaine
        Sortie sortie = mapper.toDomain(dto, produit);
        // Sauvegarde
        Sortie saved = gateway.save(sortie, produit);

        int reste = produit.getStockprod() - dto.getStock();
        produit.setStockprod(reste);
        produitRepo.save(produit);

        // Retour du DTO avec ID généré
        return mapper.toDTO(saved);
    }

    @Override
    public List<SortieRequestDTO> getAll() {
        return gateway.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SortieRequestDTO getById(Long id) {
        Sortie sortie = gateway.findById(id);
        if (sortie == null) {
            throw new RessourceIntrouvableException("Sortie avec ID " + id + " introuvable.");
        }
        return mapper.toDTO(sortie);
    }

    @Override
    public void delete(Long id) {
        Sortie exist = gateway.findById(id);
        if (exist == null) {
            throw new RessourceIntrouvableException("Sortie à supprimer introuvable avec ID " + id);
        }
        gateway.delete(id);
    }
}
