package elias.giudicelli.rest_api_island.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Mission {
	@Id
	private long id;
	private String name;
	private String status;
	private String parameters;
}
