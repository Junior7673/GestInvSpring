package io.gestionInv.Gateway.Impl;

import io.gestionInv.Domaine.Categorie;
import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Domaine.Produit;
import io.gestionInv.Mapper.ProduitMapper;
import io.gestionInv.Persistance.CategorieJPAEntity;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import io.gestionInv.Persistance.ProduitJPAEntity;
import io.gestionInv.Repository.ProduitJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return repository.save(produit);
    }

    @Override
    public List<Produit> findProduitsEnAlerte() {
        return repository.findAll().stream()
                .filter(p -> p.getStockprod() <= p.getSeuilAlerteprod())
                .collect(Collectors.toList());
    }

    @Override
    public List<Produit> findAll() {
        return new ArrayList<>(repository.findAll(Sort.by(Sort.Direction.ASC, "nomprod")));
    }

    @Override
    public List<Produit> search(String term){
        return new ArrayList<>(repository.findByNomprodContainingIgnoreCase(term));
    }

    @Override
    public List<Produit> filterByCategory(Long categorieId){
        return new ArrayList<>(repository.findByCategorieId(categorieId));
    }

    @Override
    public Produit findById(Long id) {
        Optional<Produit> entity = repository.findById(id);
        return entity.orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}

