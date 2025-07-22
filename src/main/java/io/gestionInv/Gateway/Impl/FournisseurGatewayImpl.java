package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Mapper.FournisseurMapper;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import io.gestionInv.Repository.FournisseurJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return repository.save(fournisseur);
    }

    @Override
    public List<Fournisseur> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public List<Fournisseur> search(String term)
    {
        return new ArrayList<>(repository.findByNomfourniContainingIgnoreCase(term));
    }
    @Override
    public Fournisseur findById(Long id) {
        Optional<Fournisseur> entity = repository.findById(id);
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
