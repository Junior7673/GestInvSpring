package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Mapper.SortieMapper;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Persistance.SortieJPAEntity;
import io.gestionInv.Repository.SortieJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SortieGatewayImpl implements SortieGatewayInterface{
    private final SortieJPARepository repository;
    private final SortieMapper mapper;

    @Override
    public Sortie save(Sortie sortie, Produit produit) {
        SortieJPAEntity entity = repository.save(mapper.toEntityComplete(sortie, produit));
        return mapper.toDomain(entity);
    }

    @Override
    public List<Sortie> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Sortie findById(Long id) {
        Optional<SortieJPAEntity> entity = repository.findById(id);
        return entity.map(mapper::toDomain).orElse(null);
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
