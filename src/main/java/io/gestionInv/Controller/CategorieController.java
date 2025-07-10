package io.gestionInv.Controller;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.Service.CategorieServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/categorie")
@AllArgsConstructor
public class CategorieController {
    private final CategorieServiceInterface service;

    @PostMapping("/add")
    public ResponseEntity<CategorieRequestDTO> creer(@RequestBody CategorieRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<CategorieRequestDTO>> liste() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<CategorieRequestDTO>> search(@RequestBody CategorieRequestDTO dto){
        return ResponseEntity.ok(service.search(dto.getNomcat()));
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<CategorieRequestDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
