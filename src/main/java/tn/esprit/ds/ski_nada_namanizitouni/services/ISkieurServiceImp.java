package tn.esprit.ds.ski_nada_namanizitouni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.*;
import tn.esprit.ds.ski_nada_namanizitouni.repositories.*;

import java.util.List;
import java.util.Optional;

@Service
public class ISkieurServiceImp implements ISkieurService{
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired
    CoursRepository coursRepository;
@Autowired
    AbonnementRepository abonnementRepository;
  @Autowired
    PisteRepository pisteRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return  skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }


    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Optional<Skieur> retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur);
    }

    @Override
    public Skieur updateSkieur(Skieur Skieur) {
        return skieurRepository.save(Skieur);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        //Recuperation des objets
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        //verification non null
        if(skieur != null && piste != null){
            //Traitement

            List<Piste> pistes = skieur.getPiste();
            pistes.add(piste);
            skieur.setPiste(pistes);

            //save
            pisteRepository.save(piste);
        }
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public Skieur AssignSkierToSubscription(long numSkieur, long numAbon) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Abonnement abonnement = abonnementRepository.findById(numAbon).orElse(null);
        if(skieur != null && abonnement != null){
            skieur.setAbonnement(abonnement);
            skieurRepository.save(skieur);
        }
        return null;
    }

    @Override
    public List<Skieur> retrieveSkieurBySubscriptionType(TypeAbonnement typeAbonnement) {
        return null;
    }

    @Override
    public Skieur addSkieurAndAssignToCourse(Skieur skieur) {
        Assert.notNull(skieur.getAbonnement(), "subscription not found");
        Assert.notNull(skieur.getInscription(),"not found");
        skieur.getInscription().forEach(inscription -> {
            Assert.notNull(inscription.getCours().getId(), "not found");
            Cours c=  coursRepository.findById(inscription.getCours().getId()).orElse(null);
            Assert.notNull(c,"cours not found");
            inscription.setCours(c);
        });
        skieurRepository.save(skieur);
        skieur.getInscription().forEach(inscription -> {
            inscription.setSkieur(skieur);
            inscriptionRepository.save(inscription);
        });
        return skieur;
    }

    // @Override
    public List<Skieur> retrieveSkieurBySubscriptionType(TypeAbonnement typeAbonnement, String ville) {
        return skieurRepository.findByAbonnement_TypeAbon(typeAbonnement, ville);
    }


}
