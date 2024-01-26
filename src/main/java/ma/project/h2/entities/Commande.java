package ma.project.h2.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@JsonIgnore
	@OneToMany(mappedBy="commande")
	private List<LigneCommandeProduit> lignecommandes;

	
		
	public Commande() {
		super();
	}

	public Commande(Date date, List<LigneCommandeProduit> lignecommandes) {
		super();
		this.date = date;
		this.lignecommandes = lignecommandes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<LigneCommandeProduit> getLignecommandes() {
		return lignecommandes;
	}

	public void setLignecommandes(List<LigneCommandeProduit> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}
	
	
}
