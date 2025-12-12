package elias.giudicelli.rest_api_island.service;

import elias.giudicelli.rest_api_island.model.User;
import elias.giudicelli.rest_api_island.service.exception.EmailExistsException;
import elias.giudicelli.rest_api_island.service.exception.UsernameExistsException;

public interface UserServiceInterface {
	User createUser(User user) throws EmailExistsException, UsernameExistsException;
}
