package io.gestionInv.Controller;


import io.gestionInv.Persistance.UtilisateurJPAEntity;
import io.gestionInv.Service.JwtService;
import io.gestionInv.Service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UtilisateurService utilisateurService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UtilisateurJPAEntity> register(@RequestBody UtilisateurJPAEntity utilisateur) {
        UtilisateurJPAEntity newUser = utilisateurService.enregistrer(utilisateur);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.nomUtilisateur(), request.motDePasse())
        );

        UserDetails userDetails = utilisateurService.loadUserByUsername(request.nomUtilisateur());
        String jwt = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(jwt);
    }

    // DTO pour login
   public record LoginRequest(String nomUtilisateur, String motDePasse) {}
}
