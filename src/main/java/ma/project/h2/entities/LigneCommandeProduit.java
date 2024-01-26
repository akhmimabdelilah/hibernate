package ma.project.h2.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneCommandeProduit {
	
	private int quantite;
	
	@EmbeddedId
	private LigneCommandeProduitPK pk;


	@ManyToOne
    @JoinColumn(name = "produit_id",insertable = false, updatable = false)
	private Produit produit;
	
	@ManyToOne
    @JoinColumn(name = "commande_id",insertable = false, updatable = false)
	private Commande commande;

	
	
	public LigneCommandeProduit() {
		super();
	}

	public LigneCommandeProduit(int quantite, LigneCommandeProduitPK pk) {
		super();
		this.quantite = quantite;
		this.pk = pk;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LigneCommandeProduitPK getPk() {
		return pk;
	}

	public void setPk(LigneCommandeProduitPK pk) {
		this.pk = pk;
	}
	
	

}
