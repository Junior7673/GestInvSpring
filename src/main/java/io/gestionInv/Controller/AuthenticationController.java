package io.gestionInv.Controller;


import io.gestionInv.Persistance.UtilisateurJPAEntity;
import io.gestionInv.Service.JwtService;
import io.gestionInv.Service.UtilisateurService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Getter
@Setter
public class AuthenticationController {

    private final UtilisateurService utilisateurService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UtilisateurJPAEntity> register(@RequestBody UtilisateurJPAEntity utilisateur) {
        UtilisateurJPAEntity newUser = utilisateurService.enregistrer(utilisateur);
        return ResponseEntity.ok(newUser);
    }

   /* @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.nomUtilisateur(), request.motDePasse())
        );

        UserDetails userDetails = utilisateurService.loadUserByUsername(request.nomUtilisateur());
        String jwt = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(jwt);
    }*/
   @PostMapping("/login")
   public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(request.nomUtilisateur(), request.motDePasse())
       );

       UserDetails userDetails = utilisateurService.loadUserByUsername(request.nomUtilisateur());
       String jwt = jwtService.generateToken(userDetails);

       // Récupération du rôle depuis la base de données
       UtilisateurJPAEntity utilisateur = utilisateurService
               .getUtilisateurParNom(request.nomUtilisateur());

       return ResponseEntity.ok(new LoginResponse(jwt, utilisateur.getRole().name()));
   }


    // DTO pour login
   public record LoginRequest(String nomUtilisateur, String motDePasse) {}
    // Nouveau DTO
    public record LoginResponse(String token, String role) {}
}
