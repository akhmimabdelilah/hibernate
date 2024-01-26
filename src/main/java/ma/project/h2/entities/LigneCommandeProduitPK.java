package ma.project.h2.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LigneCommandeProduitPK implements Serializable{
	
	 	@Column(name = "commande_id")
	    private int commandeId;

	    @Column(name = "produit_id")
	    private int produitId;

	
	public LigneCommandeProduitPK() {
		super();
	}


	public LigneCommandeProduitPK(int commandeId, int produitId) {
		super();
		this.commandeId = commandeId;
		this.produitId = produitId;
	}


	public int getCommandeId() {
		return commandeId;
	}


	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}


	public int getProduitId() {
		return produitId;
	}


	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	
	
	
	

}
