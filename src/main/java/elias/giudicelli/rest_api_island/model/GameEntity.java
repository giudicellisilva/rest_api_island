package elias.giudicelli.rest_api_island.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GameEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private float health;
	private float attack;
	private float defence;
	private int level;
	private float experience;
}	
