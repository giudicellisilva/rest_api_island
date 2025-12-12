package elias.giudicelli.rest_api_island.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elias.giudicelli.rest_api_island.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);
	
	Optional<User> findByUsername(String username);
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);

}
