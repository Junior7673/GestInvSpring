package io.gestionInv.Service;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Exception.RessourceIntrouvableException;
import io.gestionInv.Gateway.Impl.CategorieGatewayInterface;
import io.gestionInv.Mapper.CategorieMapper;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.CategorieJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategorieService implements CategorieServiceInterface{
    private final CategorieGatewayInterface gateway;
    private final CategorieMapper mapper;
    private final CategorieJPARepository repository;

    @Override
    public CategorieRequestDTO save(CategorieRequestDTO dto) {
        Categorie domain = mapper.toDomain(dto);
        Categorie saved = gateway.save(domain);
        return mapper.toDTO(saved);
    }

    @Override
    public List<CategorieRequestDTO> getAll() {
        return gateway.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategorieRequestDTO> search(String term) {
        return repository.findByNomcatContainingIgnoreCase(term)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategorieRequestDTO getById(Long id) {
        Categorie categorie = gateway.findById(id);
        if (categorie == null) {
            throw new RessourceIntrouvableException("Catégorie avec ID " + id + " introuvable.");
        }
        return mapper.toDTO(categorie);
    }

    @Override
    public void delete(Long id) {
        Categorie exist = gateway.findById(id);
        if (exist == null) {
            throw new RessourceIntrouvableException("Catégorie à supprimer introuvable avec ID " + id);
        }
        gateway.delete(id);
    }
}
