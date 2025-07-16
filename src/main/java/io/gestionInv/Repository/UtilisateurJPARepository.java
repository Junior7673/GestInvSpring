package io.gestionInv.Repository;

import io.gestionInv.Persistance.UtilisateurJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurJPARepository extends JpaRepository<UtilisateurJPAEntity, Long> {

    //La méthode findByNomUtilisateur permet de récupérer un utilisateur par son nom d’utilisateur (login).
    //Optional est utilisé pour gérer les cas où l’utilisateur n’existe pas.

    Optional<UtilisateurJPAEntity> findByNomUtilisateur(String nomUtilisateur);
}
