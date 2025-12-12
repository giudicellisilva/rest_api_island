package elias.giudicelli.rest_api_island.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 public enum Values {
		ADMIN(1L),
		USER(2L);
		
		Long id;
		
		Values(long id){
			this.id = id;
		}
		
		public long getId() {
			return id;
		}
		
	}
}
