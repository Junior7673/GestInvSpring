package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Mapper.CategorieMapper;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Repository.CategorieJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return repository.save(categorie);
    }
    @Override
    public List<Categorie> findAll() {
        return new ArrayList<>(repository.findAll(Sort.by(Sort.Direction.ASC, "nomcat")));
    }

    @Override
    public List<Categorie> search(String term) {
        return new ArrayList<>(repository.findByNomcatContainingIgnoreCase(term));
    }

    @Override
    public Categorie findById(Long id) {
        Optional<Categorie> entity = repository.findById(id);
        return entity.orElse(null);
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
