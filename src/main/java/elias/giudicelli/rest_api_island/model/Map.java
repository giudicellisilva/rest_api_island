package elias.giudicelli.rest_api_island.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Map {
	@Id
	private long id;
	private String name;
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "phases_id")
	 @ToString.Exclude
	 private List<Phase> phases;
}
