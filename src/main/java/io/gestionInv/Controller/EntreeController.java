package io.gestionInv.Controller;

import io.gestionInv.DTO.EntreeRequestDTO;
import io.gestionInv.DTO.PeriodRequestDTO;
import io.gestionInv.Service.EntreeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entree")
@AllArgsConstructor
public class EntreeController {
    private final EntreeService service;

    @PostMapping
    public ResponseEntity<EntreeRequestDTO> createEntree(@RequestBody EntreeRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntreeRequestDTO> getEntreeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EntreeRequestDTO>> getAllEntrees() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search/{term}")
    public ResponseEntity<List<EntreeRequestDTO>> search(@PathVariable String term) {
        return ResponseEntity.ok(service.search(term));
    }

    @PostMapping("/period")
    public ResponseEntity<List<EntreeRequestDTO>> filterByPeriod(@RequestBody PeriodRequestDTO dto) {
        return ResponseEntity.ok(service.filterByPeriod(dto.getDate1(), dto.getDate2()));
    }

    @PutMapping
    public ResponseEntity<EntreeRequestDTO> update(@RequestBody EntreeRequestDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntree(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
