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

import ma.project.h2.entities.Produit;
import ma.project.h2.services.ProduitService;


@RestController
@RequestMapping("/examblanc/produit")
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;
	
	@GetMapping
	public List<Produit> findAllProduits(){
		return produitService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Produit produit = produitService.findById(id);
		if(produit==null) {
			return new ResponseEntity<Object>("Produit with ID "+ id +" not found",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(produit);
		}
	}
	
	
	@PostMapping
	public Produit createProduit(@RequestBody Produit produit) {
		produit.setId((int) 0L);
		return produitService.create(produit);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduit(@PathVariable int id, @RequestBody Produit produit){
		if(produitService.findById(id)==null) {
			return new ResponseEntity<Object>("Produit with ID "+id+" no found", HttpStatus.BAD_REQUEST);
		}
		
		else {
			produit.setId(id);
			return ResponseEntity.ok(produitService.update(produit));
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduit(@PathVariable int id){
		Produit produit = produitService.findById(id);
		if(produit==null) {
			return new ResponseEntity<Object>("Produit with ID "+id+" not found", HttpStatus.BAD_REQUEST);
			
		}
		else {
			produitService.delete(produit);
			return ResponseEntity.ok("Produit deleted");
		}
		
	}
	
	
	
	
}
