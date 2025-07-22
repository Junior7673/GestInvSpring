package io.gestionInv.Service;

import io.gestionInv.DTO.EntreeRequestDTO;

import java.time.LocalDate;
import java.util.List;

public interface EntreeServiceInterface {
    EntreeRequestDTO save(EntreeRequestDTO dto);
    List<EntreeRequestDTO> getAll();
    List<EntreeRequestDTO> search(String term);
    List<EntreeRequestDTO> filterByPeriod(LocalDate date1, LocalDate date2);
    EntreeRequestDTO getById(Long id);
    void delete(Long id);
}
