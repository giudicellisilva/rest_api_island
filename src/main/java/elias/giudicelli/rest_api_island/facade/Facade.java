package elias.giudicelli.rest_api_island.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import elias.giudicelli.rest_api_island.model.User;
import elias.giudicelli.rest_api_island.repository.UserRepository;
import elias.giudicelli.rest_api_island.service.UserServiceInterface;
import elias.giudicelli.rest_api_island.service.exception.EmailExistsException;

public class Facade {
//	@Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private UserRepository userRepository;
//
//    public User createUser(User newUser) {
//        if (userRepository.existsByEmail(newUser.getEmail())) {
//            throw new EmailExistsException("O email '" + newUser.getEmail() + "' já está cadastrado.");
//        }
//
//        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
//
//        try {
//            return userRepository.save(newUser);
//        } catch (Exception e) {
//            throw new RuntimeException("Erro ao salvar o usuário", e);
//        }
//    }
//
//	public Optional<User> findUserById(Long id) {
//		return userRepository.findById(id);
//	}
}
