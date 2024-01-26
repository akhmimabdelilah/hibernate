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

import ma.project.h2.entities.Commande;
import ma.project.h2.services.CommandeService;


@RestController
@RequestMapping("/examblanc/commande")
public class CommandeController {
	
	@Autowired
	private CommandeService commandeService;
	
	@GetMapping
	public List<Commande> findAllCommandes(){
		return commandeService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Commande commande = commandeService.findById(id);
		if(commande==null) {
			return new ResponseEntity<Object>("Commande with ID "+ id +" not found",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(commande);
		}
	}
	
	
	@PostMapping
	public Commande createCommande(@RequestBody Commande commande) {
		commande.setId((int) 0L);
		return commandeService.create(commande);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCommande(@PathVariable int id, @RequestBody Commande commande){
		if(commandeService.findById(id)==null) {
			return new ResponseEntity<Object>("Commande with ID "+id+" no found", HttpStatus.BAD_REQUEST);
		}
		
		else {
			commande.setId(id);
			return ResponseEntity.ok(commandeService.update(commande));
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCommande(@PathVariable int id){
		Commande commande = commandeService.findById(id);
		if(commande==null) {
			return new ResponseEntity<Object>("Commande with ID "+id+" not found", HttpStatus.BAD_REQUEST);
			
		}
		else {
			commandeService.delete(commande);
			return ResponseEntity.ok("Commande deleted");
		}
		
	}
	
	
	
	
}
