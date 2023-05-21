package tn.esprit.ds.ski_nada_namanizitouni.services;

import tn.esprit.ds.ski_nada_namanizitouni.Entities.Cours;

import java.util.List;
import java.util.Optional;

public interface ICoursService {

    List<Cours> retrieveAllCours();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cours);
    Optional<Cours> retrieveCours (Long numCours);

    void removeCours(Long numCours);
    void test();
}
