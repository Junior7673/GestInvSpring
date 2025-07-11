package io.gestionInv.Service;

import io.gestionInv.DTO.EntreeRequestDTO;

import java.util.List;

public interface EntreeServiceInterface {
    EntreeRequestDTO save(EntreeRequestDTO dto);
    List<EntreeRequestDTO> getAll();
    EntreeRequestDTO getById(Long id);
    void delete(Long id);
}
