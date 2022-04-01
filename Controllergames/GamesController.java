package org.generation.Controllergames;

import java.util.List;

import org.generation.Modelgames.Games;
import org.generation.Repositorygames.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogos")
@CrossOrigin("*")
public class GamesController {
	@Autowired
	private GamesRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Games>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Games> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Games>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	@PostMapping
	public ResponseEntity<Games> post (@RequestBody Games games) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(games));
	}
	
	@PutMapping
	public ResponseEntity<Games> put (@RequestBody Games games) {
		return ResponseEntity.ok(repository.save(games));
	}
   @DeleteMapping("/{id}")
   public void delete (@PathVariable Long id) {
	   repository.deleteById(id);
   }
}
