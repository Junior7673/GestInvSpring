package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Mapper.CategorieMapper;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.CategorieJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategorieGatewayImpl implements CategorieGatewayInterface {
    private final CategorieJPARepository repository;
    private final CategorieMapper mapper;

    @Override
    public Categorie save(Categorie categorie) {
        CategorieJPAEntity entity = repository.save(mapper.toEntity(categorie));
        return mapper.toDomain(entity);
    }
    @Override
    public List<Categorie> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public Categorie findById(Long id) {
        Optional<CategorieJPAEntity> entity = repository.findById(id);
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
