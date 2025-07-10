package io.gestionInv.Service;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.DTO.FournisseurRequestDTO;

import java.util.List;

public interface FournisseurServiceInterface {
    FournisseurRequestDTO save(FournisseurRequestDTO dto);
    List<FournisseurRequestDTO> getAll();
    List<FournisseurRequestDTO> search(String term);
    FournisseurRequestDTO getById(Long id);
    void delete(Long id);
}
