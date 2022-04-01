package org.generation.Repositorygames;

import java.util.List;

import org.generation.Modelgames.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long>{
	public List<Games>  findAllByNomeContainingIgnoreCase (String nome);

}
