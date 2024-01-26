package ma.project.h2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.h2.dao.IDao;
import ma.project.h2.entities.Commande;
import ma.project.h2.repositories.CommandeRepository;


@Service
public class CommandeService implements IDao<Commande> {

	@Autowired
	private CommandeRepository commandeRepository;

	@Override
	public Commande create(Commande e) {
		return commandeRepository.save(e);
	}

	@Override
	public boolean delete(Commande e) {
		try {
			commandeRepository.delete(e);
			return true;

		} catch (Exception ex) {
			return false;
		}
	}
	
	@Override
	public Commande update(Commande e) {
		return commandeRepository.save(e);
	}
	
	@Override
	public List<Commande> findAll(){
		return commandeRepository.findAll();
	}


	public Commande findById(int id) {
		return commandeRepository.findById(id).orElse(null);
	}
}
