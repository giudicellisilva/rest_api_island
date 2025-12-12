package elias.giudicelli.rest_api_island.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elias.giudicelli.rest_api_island.model.User;
import elias.giudicelli.rest_api_island.repository.UserRepository;
import elias.giudicelli.rest_api_island.service.exception.EmailExistsException;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
}
