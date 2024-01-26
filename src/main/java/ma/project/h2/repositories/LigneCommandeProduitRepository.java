package ma.project.h2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.project.h2.entities.LigneCommandeProduit;
import ma.project.h2.entities.LigneCommandeProduitPK;
import ma.project.h2.entities.Produit;

@Repository

public interface LigneCommandeProduitRepository extends JpaRepository<LigneCommandeProduit, LigneCommandeProduitPK> {

	@Query("SELECT l.produit FROM LigneCommandeProduit l WHERE l.commande.id=:commandeId")
	List<Produit> getProdcutsByCommande(@Param("commandeId") int commandeId);

}