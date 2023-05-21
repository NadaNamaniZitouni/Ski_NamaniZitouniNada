package tn.esprit.ds.ski_nada_namanizitouni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription,Long > {
}
