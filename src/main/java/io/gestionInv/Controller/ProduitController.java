package io.gestionInv.Controller;

import io.gestionInv.DTO.CategorieRequestDTO;
import io.gestionInv.DTO.ProduitRequestDTO;
import io.gestionInv.Service.ProduitServiceInterface;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {

    private final ProduitServiceInterface service;
    private static final Logger logger = LoggerFactory.getLogger(ProduitController.class);

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<ProduitRequestDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProduit(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ProduitRequestDTO> creer(@RequestBody ProduitRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping("/search")
    public ResponseEntity<List<ProduitRequestDTO>> search(@RequestBody ProduitRequestDTO dto) {
        return ResponseEntity.ok(service.search(dto.getNomprod()));
    }

    @GetMapping
    public ResponseEntity<List<ProduitRequestDTO>> liste() {
        return ResponseEntity.ok(service.liste());
    }

    @GetMapping("/alerte")
    public ResponseEntity<List<ProduitRequestDTO>> produitsEnAlerte() {
        return ResponseEntity.ok(service.produitsEnAlerte());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}