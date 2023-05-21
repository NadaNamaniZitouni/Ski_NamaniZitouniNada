package tn.esprit.ds.ski_nada_namanizitouni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Abonnement;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Skieur;
import tn.esprit.ds.ski_nada_namanizitouni.repositories.AbonnementRepository;
import tn.esprit.ds.ski_nada_namanizitouni.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class scheduledTasks {
    @Autowired
    private AbonnementRepository abonnementRepository;

    @Autowired
    private SkieurRepository skieurRepository;

    @Scheduled(fixedRate = 604800000) // exécuté toutes les semaines (7 jours = 604800000 ms)
    public void retrieveSubscriptions() {
        LocalDate now = LocalDate.now();
        LocalDate endDate = now.plusDays(7);
        List<Abonnement> abonnements = abonnementRepository.findByDateDebutAfterAndDateFinBefore(now, endDate);
        for (Abonnement abonnement : abonnements) {
            Skieur skieur = skieurRepository.findByAbonnement(abonnement);
            System.out.println("Abonnement " + abonnement.getNumAbon() + " du skieur " +
                    skieur.getNomS() + " " + skieur.getPrenomS() + " (numSkieur " + skieur.getNumSkieur() +
                    ") se termine le " + abonnement.getDateFin());
        }
    }
}
