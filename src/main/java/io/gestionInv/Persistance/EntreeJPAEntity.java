package io.gestionInv.Persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gestionInv.Domaine.Entree;
import io.gestionInv.Domaine.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="Entree")
public class EntreeJPAEntity extends Entree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stock;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private ProduitJPAEntity produit;
}
