package io.gestionInv.Service;

import io.gestionInv.DTO.ProduitRequestDTO;

import java.util.List;

public interface ProduitServiceInterface {
    List<ProduitRequestDTO> liste();
    List<ProduitRequestDTO> search(String term);
    List<ProduitRequestDTO> filterByCategory(Long categorieId);
    List<ProduitRequestDTO> produitsEnAlerte();
    ProduitRequestDTO getProduit(Long id);
    void delete(Long id);

    ProduitRequestDTO save(ProduitRequestDTO dto);
}
