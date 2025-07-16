package io.gestionInv.Persistance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Utilisateur")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtilisateurJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomUtilisateur;

    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, UTILISATEUR
    }
}
