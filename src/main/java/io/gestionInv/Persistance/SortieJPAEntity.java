package io.gestionInv.Persistance;

import io.gestionInv.Domaine.Produit;
import io.gestionInv.Domaine.Sortie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="Sortie")
public class SortieJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stock;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;
}
