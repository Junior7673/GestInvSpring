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
    public Produit save(Produit produit, Categorie categorie, Fournisseur fournisseur) {
        ProduitJPAEntity entity = repository.save(mapper.toEntity(produit, categorie, fournisseur));
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
    public List<Produit> search(String term){
        return repository.findByNomprodContainingIgnoreCase(term)
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

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

