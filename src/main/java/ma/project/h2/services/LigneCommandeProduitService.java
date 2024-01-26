package ma.project.h2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.h2.dao.IDao;
import ma.project.h2.entities.LigneCommandeProduit;
import ma.project.h2.entities.LigneCommandeProduitPK;
import ma.project.h2.entities.Produit;
import ma.project.h2.repositories.LigneCommandeProduitRepository;

@Service
public class LigneCommandeProduitService implements IDao<LigneCommandeProduit> {

	@Autowired
	private LigneCommandeProduitRepository ligneCommandeProduitRepository;

	@Override
	public LigneCommandeProduit create(LigneCommandeProduit e) {
		return ligneCommandeProduitRepository.save(e);
	}

	@Override
	public boolean delete(LigneCommandeProduit e) {
		try {
			ligneCommandeProduitRepository.delete(e);
			return true;

		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public LigneCommandeProduit update(LigneCommandeProduit e) {
		return ligneCommandeProduitRepository.save(e);
	}

	@Override
	public List<LigneCommandeProduit> findAll() {
		return ligneCommandeProduitRepository.findAll();
	}

	public LigneCommandeProduit findById(LigneCommandeProduitPK id) {
		return ligneCommandeProduitRepository.findById(id).orElse(null);
	}

	public List<Produit> getProdcutsByCommande(int commandeId) {
		return ligneCommandeProduitRepository.getProdcutsByCommande(commandeId);
	}
}
