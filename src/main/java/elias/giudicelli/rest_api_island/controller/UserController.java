package elias.giudicelli.rest_api_island.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import elias.giudicelli.rest_api_island.config.SecurityConfig;
import elias.giudicelli.rest_api_island.controller.dto.request.UserRequest;
import elias.giudicelli.rest_api_island.controller.dto.response.UserResponse;
import elias.giudicelli.rest_api_island.model.Role;
import elias.giudicelli.rest_api_island.model.User;
import elias.giudicelli.rest_api_island.repository.RoleRepository;
import elias.giudicelli.rest_api_island.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
@Tag(name = "Users")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class UserController {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public UserController(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        var basicRole = roleRepository.findByName(Role.Values.USER.name());
        var userFromDb = userRepository.findByUsername(userRequest.username());
        if (userFromDb.isPresent()) {
        	throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    	var user = new User();
    	user.setUsername(userRequest.username());
    	user.setPassword(passwordEncoder.encode(userRequest.password()));
    	user.setRoles(Set.of(basicRole));
    	
    	userRepository.save(user);
    	
        return ResponseEntity.ok(new UserResponse());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @Operation(summary = "All Users")
    public ResponseEntity<List<User>> listUsers() {
        var users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
