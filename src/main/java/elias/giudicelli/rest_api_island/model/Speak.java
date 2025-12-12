package elias.giudicelli.rest_api_island.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
@ToString
public class Speak {
	@Id
	private long id;
	private String speak;
	
	 @OneToMany(mappedBy = "speak", cascade = CascadeType.ALL, orphanRemoval = true)
	    @ToString.Exclude
	    private List<Speak> speaks;
}
