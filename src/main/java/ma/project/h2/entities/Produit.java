package ma.project.h2.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reference;
	private float prix;
	
	@ManyToOne
	private Categorie categorie;

	@JsonIgnore
	@OneToMany(mappedBy="produit")
	private List<LigneCommandeProduit> lignecommandes;

	
	public Produit() {
		super();
	}


	public Produit(String reference, float prix, Categorie categorie, List<LigneCommandeProduit> lignecommandes) {
		super();
		this.reference = reference;
		this.prix = prix;
		this.categorie = categorie;
		this.lignecommandes = lignecommandes;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<LigneCommandeProduit> getLignecommandes() {
		return lignecommandes;
	}


	public void setLignecommandes(List<LigneCommandeProduit> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}
	
	

}
