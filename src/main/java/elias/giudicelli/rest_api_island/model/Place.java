package elias.giudicelli.rest_api_island.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Place {
	@Id
	private long id;
	private String name;
}
