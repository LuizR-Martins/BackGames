package org.generation.Repositorygames;

import java.util.List;

import org.generation.Modelgames.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	public List<Categoria>  findAllByEstiloContainingIgnoreCase (String estilo);

}
