package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Domaine.Sortie;
import io.gestionInv.Mapper.SortieMapper;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Persistance.SortieJPAEntity;
import io.gestionInv.Repository.SortieJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SortieGatewayImpl implements SortieGatewayInterface{
    private final SortieJPARepository repository;
    private final SortieMapper mapper;

    @Override
    public Sortie save(Sortie sortie) {
        return repository.save(sortie);
    }

    @Override
    public List<Sortie> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public List<Sortie> search(String term) {
        return new ArrayList<>(repository.findByProduit_NomprodContainingIgnoreCase(term));
    }

    @Override
    public List<Sortie> filterByPeriod(LocalDate date1, LocalDate date2){
        return new ArrayList<>(repository.findByDateBetween(date1, date2));
    }

    @Override
    public Sortie findById(Long id) {
        Optional<Sortie> entity = repository.findById(id);
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
