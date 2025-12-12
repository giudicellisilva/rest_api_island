package elias.giudicelli.rest_api_island.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Phase {
	@Id
	private long id;
	private String name;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "stores_id")
	@ToString.Exclude
	private List<Store> stores;
}
