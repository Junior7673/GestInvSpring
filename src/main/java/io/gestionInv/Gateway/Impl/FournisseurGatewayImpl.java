package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Mapper.FournisseurMapper;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import io.gestionInv.Repository.FournisseurJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FournisseurGatewayImpl implements FournisseurGatewayInterface{
    private final FournisseurJPARepository repository;
    private final FournisseurMapper mapper;

    @Override
    public Fournisseur save(Fournisseur fournisseur) {
        FournisseurJPAEntity entity = repository.save(mapper.toEntity(fournisseur));
        return mapper.toDomain(entity);
    }

    @Override
    public List<Fournisseur> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public FournisseurJPAEntity findById(Long id) {
        /*Optional<FournisseurJPAEntity> entity = repository.findById(id);
        return entity.map(mapper::toEntity).orElse(null);*/
        Optional<FournisseurJPAEntity> entity = repository.findById(id);
        return (FournisseurJPAEntity) entity.map(mapper::toDomain).orElse(null);
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
