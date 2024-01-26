package ma.project.h2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.h2.dao.IDao;
import ma.project.h2.entities.Categorie;
import ma.project.h2.repositories.CategorieRepository;


@Service
public class CategorieService implements IDao<Categorie> {

	@Autowired
	private CategorieRepository categorieRepository;

	@Override
	public Categorie create(Categorie e) {
		return categorieRepository.save(e);
	}

	@Override
	public boolean delete(Categorie e) {
		try {
			categorieRepository.delete(e);
			return true;

		} catch (Exception ex) {
			return false;
		}
	}
	
	@Override
	public Categorie update(Categorie e) {
		return categorieRepository.save(e);
	}
	
	@Override
	public List<Categorie> findAll(){
		return categorieRepository.findAll();
	}

	
	public Categorie findById(int id) {
		return categorieRepository.findById(id).orElse(null);
	}
}
