package io.gestionInv.Controller;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.DTO.FournisseurRequestDTO;
import io.gestionInv.Service.FournisseurServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/fournisseur")
public class FournisseurController {
    private final FournisseurServiceInterface service;

    @PostMapping("/add")
    public ResponseEntity<FournisseurRequestDTO> creer(@RequestBody FournisseurRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<FournisseurRequestDTO>> liste() {

        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<FournisseurRequestDTO>> search(@RequestBody FournisseurRequestDTO dto){
        return ResponseEntity.ok(service.search(dto.getNomfourni()));
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<FournisseurRequestDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FournisseurRequestDTO> update(@RequestBody FournisseurRequestDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
