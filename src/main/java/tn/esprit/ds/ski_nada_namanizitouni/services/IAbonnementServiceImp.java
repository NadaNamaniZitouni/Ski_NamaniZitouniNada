package tn.esprit.ds.ski_nada_namanizitouni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Abonnement;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.TypeAbonnement;
import tn.esprit.ds.ski_nada_namanizitouni.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IAbonnementServiceImp implements IAbonnementService{

    @Autowired
    AbonnementRepository abonnementRepository;
    @Override
    public List<Abonnement> retrieveAllAbonnement() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Optional<Abonnement> retrieveAbonnement(Long numAbon) {
        return abonnementRepository.findById(numAbon);
    }

    @Override
    public void removeAbonnement(Long numAbon) {
        abonnementRepository.deleteById(numAbon);
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbonnement) {
        return abonnementRepository.findByTypeAbonOrderByDateDebut(typeAbonnement);
    }

    @Override
    public List<Abonnement> findSubscriptionByDateDebutBetween(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findByDateDebutAfterAndDateFinBefore(startDate, endDate);
    }
}
