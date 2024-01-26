package ma.project.h2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.h2.entities.Commande;

@Repository

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
