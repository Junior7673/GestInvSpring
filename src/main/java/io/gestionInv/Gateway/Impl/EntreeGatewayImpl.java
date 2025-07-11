package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Mapper.EntreeMapper;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.EntreeJPAEntity;
import io.gestionInv.Persistance.EntreeJPARepository;
import io.gestionInv.Persistance.ProduitJPAEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntreeGatewayImpl implements EntreeGatewayInterface{
    private final EntreeJPARepository repository;
    private final EntreeMapper mapper;

    @Override
    public Entree save(Entree entree, ProduitJPAEntity produit) {
        EntreeJPAEntity entity = repository.save(mapper.toEntityComplete(entree, produit));
        return mapper.toDomain(entity);
    }

    @Override
    public List<Entree> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public EntreeJPAEntity findById(Long id) {
        Optional<EntreeJPAEntity> entity = repository.findById(id);
        return entity.map(mapper::toEntity).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
