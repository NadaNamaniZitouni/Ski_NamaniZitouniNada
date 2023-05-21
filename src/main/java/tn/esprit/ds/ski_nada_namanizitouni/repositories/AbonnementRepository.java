package tn.esprit.ds.ski_nada_namanizitouni.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Abonnement;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.TypeAbonnement;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
   // List<Abonnement> findByTypeAbonnement(TypeAbonnement typeAbonnement);
    Set<Abonnement> findByTypeAbonOrderByDateDebut(TypeAbonnement typeAbonnement);
    List<Abonnement> findByDateDebutAfterAndDateFinBefore(LocalDate startDate, LocalDate endDate);
}
