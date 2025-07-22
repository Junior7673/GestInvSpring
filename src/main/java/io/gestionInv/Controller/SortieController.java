package io.gestionInv.Controller;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.DTO.EntreeRequestDTO;
import io.gestionInv.DTO.PeriodRequestDTO;
import io.gestionInv.DTO.SortieRequestDTO;
import io.gestionInv.Service.SortieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sortie")
@AllArgsConstructor
public class SortieController {
    private final SortieService service;

    @PostMapping
    public ResponseEntity<SortieRequestDTO> createSortie(@RequestBody SortieRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SortieRequestDTO> getSortieById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SortieRequestDTO>> getAllSorties() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search/{term}")
    public ResponseEntity<List<SortieRequestDTO>> search(@PathVariable String term) {
        return ResponseEntity.ok(service.search(term));
    }

    @PostMapping("/period")
    public ResponseEntity<List<SortieRequestDTO>> filterByPeriod(@RequestBody PeriodRequestDTO dto) {
        return ResponseEntity.ok(service.filterByPeriod(dto.getDate1(), dto.getDate2()));
    }

    @PutMapping
    public ResponseEntity<SortieRequestDTO> update(@RequestBody SortieRequestDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSortie(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
