package elias.giudicelli.rest_api_island.controller;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;
import elias.giudicelli.rest_api_island.controller.dto.request.AuthRequest;
import elias.giudicelli.rest_api_island.controller.dto.response.AuthResponse;
import elias.giudicelli.rest_api_island.model.Role;
import elias.giudicelli.rest_api_island.repository.UserRepository;

@RestController
public class AuthController {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AuthController(JwtEncoder jwtEncoder,
                           UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
    	var user = userRepository.findByUsername(authRequest.username());
       
       if (user.isEmpty() || !user.get().isAuthCorrect(authRequest, passwordEncoder)) {
    	   throw new BadCredentialsException("user or password is invalid!");
       }
       
       var now = Instant.now();
       var expiresIn = 300L;
       
       var scopes = user.get().getRoles()
               .stream()
               .map(Role::getName)
               .collect(Collectors.joining(" "));
       
       var claims = JwtClaimsSet.builder()
               .issuer("mybackend")
               .subject(String.valueOf(user.get().getId()))
               .issuedAt(now)
               .expiresAt(now.plusSeconds(expiresIn))
               .claim("scope", scopes)
               .build();
               
       var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

       return ResponseEntity.ok(new AuthResponse(jwtValue, expiresIn));
    }
}