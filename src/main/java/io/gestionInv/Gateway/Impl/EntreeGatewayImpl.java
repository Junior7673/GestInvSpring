package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Mapper.EntreeMapper;
import io.gestionInv.Persistance.EntreeJPAEntity;
import io.gestionInv.Repository.EntreeJPARepository;
import io.gestionInv.Persistance.ProduitJPAEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntreeGatewayImpl implements EntreeGatewayInterface{
    private final EntreeJPARepository repository;
    private final EntreeMapper mapper;

   @Override
    public Entree save(Entree entree) {
       return repository.save(entree);
    }

    @Override
    public List<Entree> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public List<Entree> search(String term) {
        return new ArrayList<>(repository.findByProduit_NomprodContainingIgnoreCase(term));
    }

    @Override
    public List<Entree> filterByPeriod(LocalDate date1, LocalDate date2){
        return new ArrayList<>(repository.findByDateBetween(date1, date2));
    }

    @Override
    public Entree findById(Long id) {
        Optional<Entree> entity = repository.findById(id);
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
