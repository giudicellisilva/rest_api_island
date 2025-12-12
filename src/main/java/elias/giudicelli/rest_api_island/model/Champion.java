package elias.giudicelli.rest_api_island.model;



import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Champion extends GameEntity{
	private String status;
	
}
