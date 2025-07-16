package io.gestionInv.Service;

import io.gestionInv.DTO.FournisseurRequestDTO;
import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Exception.RessourceIntrouvableException;
import io.gestionInv.Gateway.Impl.FournisseurGatewayInterface;
import io.gestionInv.Mapper.FournisseurMapper;
import io.gestionInv.Repository.FournisseurJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FournisseurService implements FournisseurServiceInterface{
    private final FournisseurGatewayInterface gateway;
    private final FournisseurMapper mapper;
    private final FournisseurJPARepository repository;

    @Override
    public FournisseurRequestDTO save(FournisseurRequestDTO dto) {
        Fournisseur domain = mapper.toDomain(dto);
        Fournisseur saved = gateway.save(domain);
        return mapper.toDTO(saved);
    }

    @Override
    public List<FournisseurRequestDTO> getAll() {
        return gateway.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FournisseurRequestDTO> search(String term) {
        return repository.findByNomfourniContainingIgnoreCase(term)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FournisseurRequestDTO getById(Long id) {
        Fournisseur fournisseur = gateway.findById(id);
        if (fournisseur == null) {
            throw new RessourceIntrouvableException("Fournisseur avec ID " + id + " introuvable.");
        }
        return mapper.toDTO(fournisseur);
    }

    @Override
    public void delete(Long id) {
        Fournisseur exist = gateway.findById(id);
        if (exist == null) {
            throw new RessourceIntrouvableException("Fournisseur à supprimer introuvable avec ID " + id);
        }
        gateway.delete(id);

    }
}
