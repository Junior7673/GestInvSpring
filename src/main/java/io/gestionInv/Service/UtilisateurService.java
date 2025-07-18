package io.gestionInv.Service;

import io.gestionInv.Persistance.UtilisateurJPAEntity;
import io.gestionInv.Repository.UtilisateurJPARepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class UtilisateurService implements UserDetailsService {

    private final UtilisateurJPARepository utilisateurRepository;
    //private final PasswordEncoder passwordEncoder;

    // Enregistrement d’un nouvel utilisateur
    public UtilisateurJPAEntity enregistrer(UtilisateurJPAEntity utilisateur) {
        /*utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return utilisateurRepository.save(utilisateur);*/
        String encodedPassword = new BCryptPasswordEncoder().encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(encodedPassword);
        return utilisateurRepository.save(utilisateur);
    }

    // Recherche d’un utilisateur par son nom pour Spring Security
    @Override
    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
        UtilisateurJPAEntity utilisateur = utilisateurRepository.findByNomUtilisateur(nomUtilisateur)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        return User.builder()
                .username(utilisateur.getNomUtilisateur())
                .password(utilisateur.getMotDePasse())
                .roles(utilisateur.getRole().name())
                .build();
    }

    /*public UtilisateurJPAEntity findByNomUtilisateur(String nomUtilisateur) {
        return utilisateurRepository.findByNomUtilisateur(nomUtilisateur)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
    }*/
    public UtilisateurJPAEntity getUtilisateurParNom(String nom) {
        return utilisateurRepository.findByNomUtilisateur(nom)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
    }


}
