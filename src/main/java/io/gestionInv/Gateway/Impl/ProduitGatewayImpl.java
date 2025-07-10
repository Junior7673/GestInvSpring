package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.Mapper.ProduitMapper;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Persistance.ProduitJPARepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitGatewayImpl implements ProduitGatewayInterface {
    private final ProduitJPARepository repository;
    private final ProduitMapper mapper;


    @Override
    public Produit save(Produit produit) {
        ProduitJPAEntity entity = repository.save(mapper.toEntity(produit));
        return mapper.toDomain(entity);
    }

    @Override
    public List<Produit> findProduitsEnAlerte() {
        return repository.findAll().stream()
                .filter(p -> p.getStockprod() <= p.getSeuilAlerteprod())
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produit> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());    }

    @Override
    public Produit findById(Long id) {
        Optional<ProduitJPAEntity> entity = repository.findById(id);
        return entity.map(mapper::toDomain).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}

