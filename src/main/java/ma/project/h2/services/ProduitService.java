package ma.project.h2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.h2.dao.IDao;
import ma.project.h2.entities.Produit;
import ma.project.h2.repositories.ProduitRepository;


@Service
public class ProduitService implements IDao<Produit> {

	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public Produit create(Produit e) {
		return produitRepository.save(e);
	}

	@Override
	public boolean delete(Produit e) {
		try {
			produitRepository.delete(e);
			return true;

		} catch (Exception ex) {
			return false;
		}
	}
	
	@Override
	public Produit update(Produit e) {
		return produitRepository.save(e);
	}
	
	@Override
	public List<Produit> findAll(){
		return produitRepository.findAll();
	}


	public Produit findById(int id) {
		return produitRepository.findById(id).orElse(null);
	}
}
