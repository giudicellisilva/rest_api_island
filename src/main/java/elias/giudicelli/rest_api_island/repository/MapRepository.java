package elias.giudicelli.rest_api_island.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import elias.giudicelli.rest_api_island.model.Map;

public interface MapRepository extends JpaRepository<Map, Long> {
	
}
