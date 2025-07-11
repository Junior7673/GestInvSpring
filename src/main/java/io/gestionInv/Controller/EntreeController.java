package io.gestionInv.Controller;

import io.gestionInv.DTO.EntreeRequestDTO;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntree(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
