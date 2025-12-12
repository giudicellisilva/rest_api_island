package elias.giudicelli.rest_api_island.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Enemy extends GameEntity{
	private float dropExperience;
	private boolean hostile;
	
	@ManyToMany
	@JoinTable(
		       name = "enemy_resource", // nome da tabela intermediária
		       joinColumns = @JoinColumn(name = "enemy_id"), // FK do user
		       inverseJoinColumns = @JoinColumn(name = "resource_id") // FK do title
		   )
	private List<Resource> drops;
}
