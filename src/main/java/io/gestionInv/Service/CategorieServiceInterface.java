package io.gestionInv.Service;

import io.gestionInv.DTO.CategorieRequestDTO;

import java.util.List;

public interface CategorieServiceInterface {
    CategorieRequestDTO save(CategorieRequestDTO dto);
    List<CategorieRequestDTO> getAll();
    List<CategorieRequestDTO> search(String term);
    CategorieRequestDTO getById(Long id);
    void delete(Long id);
}
