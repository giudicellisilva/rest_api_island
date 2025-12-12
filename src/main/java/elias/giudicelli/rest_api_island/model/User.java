package elias.giudicelli.rest_api_island.model;

import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import elias.giudicelli.rest_api_island.controller.dto.request.AuthRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Data
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	@Column(unique = true)
	private String username;
	
	private String password;
	private String email;
	private int level;
	private float experience;
	private float gold;
	
	
	@ManyToMany
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles;
	

	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(
		        name = "user_champion", // nome da tabela intermediária
		        joinColumns = @JoinColumn(name = "user_id"), // FK do user
		        inverseJoinColumns = @JoinColumn(name = "champion_id") // FK do title
		    )
	 private List<Champion> champions;
	 
	 @ManyToMany
	 @JoinTable(
		        name = "user_title", // nome da tabela intermediária
		        joinColumns = @JoinColumn(name = "user_id"), // FK do user
		        inverseJoinColumns = @JoinColumn(name = "title_id") // FK do title
		    )
	 private List<Title> titles;
	 
	 @ManyToMany
	 @JoinTable(
		        name = "user_resource", // nome da tabela intermediária
		        joinColumns = @JoinColumn(name = "user_id"), // FK do user
		        inverseJoinColumns = @JoinColumn(name = "resource_id") // FK do title
		    )
	 private List<Resource> resources;
	 
	 @ManyToMany
	 @JoinTable(
		        name = "user_mission", // nome da tabela intermediária
		        joinColumns = @JoinColumn(name = "user_id"), // FK do user
		        inverseJoinColumns = @JoinColumn(name = "mission_id") // FK do title
		    )
	 private List<Mission> missions;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "battles_id")
	 @ToString.Exclude
	 private List<Battle> battles;
	 
	 
	 
	 
	 public long getId() {
		return id;
	}

	 public void setId(long id) {
		 this.id = id;
	 }

	 public String getUsername() {
		 return username;
	 }

	 public void setUsername(String username) {
		 this.username = username;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public int getLevel() {
		 return level;
	 }

	 public void setLevel(int level) {
		 this.level = level;
	 }

	 public float getExperience() {
		 return experience;
	 }

	 public void setExperience(float experience) {
		 this.experience = experience;
	 }

	 public float getGold() {
		 return gold;
	 }

	 public void setGold(float gold) {
		 this.gold = gold;
	 }

	 public Set<Role> getRoles() {
		 return roles;
	 }

	 public void setRoles(Set<Role> roles) {
		 this.roles = roles;
	 }

	 public List<Champion> getChampions() {
		 return champions;
	 }

	 public void setChampions(List<Champion> champions) {
		 this.champions = champions;
	 }

	 public List<Title> getTitles() {
		 return titles;
	 }

	 public void setTitles(List<Title> titles) {
		 this.titles = titles;
	 }

	 public List<Resource> getResources() {
		 return resources;
	 }

	 public void setResources(List<Resource> resources) {
		 this.resources = resources;
	 }

	 public List<Mission> getMissions() {
		 return missions;
	 }

	 public void setMissions(List<Mission> missions) {
		 this.missions = missions;
	 }

	 public List<Battle> getBattles() {
		 return battles;
	 }

	 public void setBattles(List<Battle> battles) {
		 this.battles = battles;
	 }
	 
	 public boolean isAuthCorrect(AuthRequest authRequest, PasswordEncoder passwordEnconder) {
		 return passwordEnconder.matches(authRequest.password(), this.password);
		 
	 }

	
}
