package io.gestionInv.Controller;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSortie(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
