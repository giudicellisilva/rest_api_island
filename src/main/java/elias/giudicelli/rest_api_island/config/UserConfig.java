package elias.giudicelli.rest_api_island.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import elias.giudicelli.rest_api_island.model.Role;
import elias.giudicelli.rest_api_island.model.User;
import elias.giudicelli.rest_api_island.repository.RoleRepository;
import elias.giudicelli.rest_api_island.repository.UserRepository;
import jakarta.transaction.Transactional;

@Component
public class UserConfig implements CommandLineRunner {

    private UserRepository userRepository;
    
    private RoleRepository roleRepository;
    
    private BCryptPasswordEncoder passwordEncoder;
    
    public UserConfig(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
    	this.roleRepository = roleRepository;
    	this.userRepository = userRepository;
    	this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        var roleUser = roleRepository.findByName(Role.Values.USER.name());
        
        var userAdmin = userRepository.findByUsername("admin");
      
        var userUser = userRepository.findByUsername("user");
        
        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("admin ja existe");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("12345"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                }
        );
        
        userUser.ifPresentOrElse(
                user -> {
                    System.out.println("User ja existe");
                },
                () -> {
                    var user = new User();
                    user.setUsername("user");
                    user.setPassword(passwordEncoder.encode("12345"));
                    user.setRoles(Set.of(roleUser));
                    userRepository.save(user);
                }
        );
    }
}
