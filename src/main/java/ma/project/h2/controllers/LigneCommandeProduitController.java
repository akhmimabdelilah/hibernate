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

import ma.project.h2.entities.LigneCommandeProduit;
import ma.project.h2.entities.LigneCommandeProduitPK;
import ma.project.h2.entities.Produit;
import ma.project.h2.services.LigneCommandeProduitService;

@RestController
@RequestMapping("/examblanc/ligneCommandeProduit")
public class LigneCommandeProduitController {

	@Autowired
	private LigneCommandeProduitService ligneCommandeProduitService;

	@GetMapping
	public List<LigneCommandeProduit> findAllLigneCommandeProduits() {
		return ligneCommandeProduitService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable LigneCommandeProduitPK id) {
		LigneCommandeProduit ligneCommandeProduit = ligneCommandeProduitService.findById(id);
		if (ligneCommandeProduit == null) {
			return new ResponseEntity<Object>("LigneCommandeProduit with ID " + id + " not found",
					HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(ligneCommandeProduit);
		}
	}

	@PostMapping
	public LigneCommandeProduit createLigneCommandeProduit(@RequestBody LigneCommandeProduit ligneCommandeProduit) {
		// ligneCommandeProduit.setPk(0L);
		return ligneCommandeProduitService.create(ligneCommandeProduit);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateLigneCommandeProduit(@PathVariable LigneCommandeProduitPK id,
			@RequestBody LigneCommandeProduit ligneCommandeProduit) {
		if (ligneCommandeProduitService.findById(id) == null) {
			return new ResponseEntity<Object>("LigneCommandeProduit with ID " + id + " no found",
					HttpStatus.BAD_REQUEST);
		}

		else {
			ligneCommandeProduit.setPk(id);
			return ResponseEntity.ok(ligneCommandeProduitService.update(ligneCommandeProduit));
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteLigneCommandeProduit(@PathVariable LigneCommandeProduitPK id) {
		LigneCommandeProduit ligneCommandeProduit = ligneCommandeProduitService.findById(id);
		if (ligneCommandeProduit == null) {
			return new ResponseEntity<Object>("LigneCommandeProduit with ID " + id + " not found",
					HttpStatus.BAD_REQUEST);

		} else {
			ligneCommandeProduitService.delete(ligneCommandeProduit);
			return ResponseEntity.ok("LigneCommandeProduit deleted");
		}

	}

	@GetMapping("/byCommande/{commandeId}")
	public ResponseEntity<List<Produit>> getProduitsByCommande(@PathVariable int commandeId) {
		List<Produit> produits = ligneCommandeProduitService.getProdcutsByCommande(commandeId);

		if (produits.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(produits, HttpStatus.OK);
		}
	}
	
}
