package io.gestionInv.Service;

import io.gestionInv.DTO.SortieRequestDTO;

import java.util.List;

public interface SortieServiceInterface {
    SortieRequestDTO save(SortieRequestDTO dto);
    List<SortieRequestDTO> getAll();
    SortieRequestDTO getById(Long id);
    void delete(Long id);
}
