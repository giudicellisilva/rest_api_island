package elias.giudicelli.rest_api_island.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class NPC {
	@Id
	private long id;
	private String name;
	
	@ManyToMany
	@JoinTable(
		       name = "NPC_speak", // nome da tabela intermediária
		       joinColumns = @JoinColumn(name = "NPC_id"), // FK do user
		       inverseJoinColumns = @JoinColumn(name = "speak_id") // FK do title
		   )
	private List<Speak> speaks;
}
