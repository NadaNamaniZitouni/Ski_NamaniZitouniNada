package tn.esprit.ds.ski_nada_namanizitouni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.*;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long > {
    @Query("select s from Skieur s where s.abonnement.typeAbon = ?1 and s.ville =?2")
List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement typeAbonnement, String ville);

    @Query("select s from Skieur s where s.abonnement.typeAbon = :typeAbonnement and s.ville =:ville")
    List<Skieur> findByAbonnement_TypeAbon2(@Param("typeAbonnement")TypeAbonnement typeAbonnement, @Param("ville") String ville);
List<Skieur> findByInscriptionCoursTypeCoursAndInscriptionCoursSupportAndPisteCouleur(TypeCours typeCours, Support support, Couleur couleur);

@Query(value="SELECT * " +
        "FROM skieur join inscription i on i.skieur_num_skieur=s.num_skieur\n" +
        "join cours c on i.cours_num_cours=c.num_cours\n" +
        "join monitor_cours mc on c.num_cours=mc.monitor_num_monitor \n" +
        "join moniteur m on m.num_moniteur=mc.monitor_num_monitor\n" +
        "where (c.support= :support) AND (m.nom= :nom)", nativeQuery = true)
List<Skieur> findByMoniteurNameAndSupportTypeSQL(@Param("support") Support support, @Param("nom") String nom);
@Query("select i.skieur from Inscription i " +
        "join Monitor m on i.cours member of m.cours " +
        "where(i.cours.support= :support) AND (m.nomM= :nomM)")
List<Skieur>findByMoniteurNameAndSupportTypeJPQL(@Param("support") Support support, @Param("nomM") String nom);

@Query("select s from Skieur s where s.abonnement = ?1")
    Skieur findByAbonnement(Abonnement abonnement);
}
