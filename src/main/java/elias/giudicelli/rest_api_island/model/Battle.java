package elias.giudicelli.rest_api_island.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
@ToString
public class Battle {
	@Id
	private long id;
	private boolean result;
	
	@ManyToMany
    @JoinTable(
        name = "battle_enemy",
        joinColumns = @JoinColumn(name = "battle_id"),
        inverseJoinColumns = @JoinColumn(name = "enemy_id")
    )
    private List<Enemy> enemies = new ArrayList<>();

}
