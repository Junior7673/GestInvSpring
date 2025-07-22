package io.gestionInv.Service;

import io.gestionInv.DTO.SortieRequestDTO;

import java.time.LocalDate;
import java.util.List;

public interface SortieServiceInterface {
    SortieRequestDTO save(SortieRequestDTO dto);
    List<SortieRequestDTO> getAll();
    List<SortieRequestDTO> search(String term);
    List<SortieRequestDTO> filterByPeriod(LocalDate date1, LocalDate date2);
    SortieRequestDTO getById(Long id);
    void delete(Long id);
}
