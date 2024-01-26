package ma.project.h2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.project.h2.entities.Categorie;
import ma.project.h2.services.CategorieService;


@RestController
@RequestMapping("/examblanc/categorie")
public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping
	public List<Categorie> findAllCategories(){
		return categorieService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Categorie categorie = categorieService.findById(id);
		if(categorie==null) {
			return new ResponseEntity<Object>("Categorie with ID "+ id +" not found",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(categorie);
		}
	}
	
	
	@PostMapping
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		categorie.setId((int) 0L);
		return categorieService.create(categorie);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategorie(@PathVariable int id, @RequestBody Categorie categorie){
		if(categorieService.findById(id)==null) {
			return new ResponseEntity<Object>("Categorie with ID "+id+" no found", HttpStatus.BAD_REQUEST);
		}
		
		else {
			categorie.setId(id);
			return ResponseEntity.ok(categorieService.update(categorie));
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable int id){
		Categorie categorie = categorieService.findById(id);
		if(categorie==null) {
			return new ResponseEntity<Object>("Categorie with ID "+id+" not found", HttpStatus.BAD_REQUEST);
			
		}
		else {
			categorieService.delete(categorie);
			return ResponseEntity.ok("Categorie deleted");
		}
		
	}
	
	
	
	
}
