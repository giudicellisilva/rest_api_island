package elias.giudicelli.rest_api_island.service.exception;

public class EmailExistsException extends RuntimeException {
	
	public EmailExistsException(String message) {
		super(message);
	}

}
