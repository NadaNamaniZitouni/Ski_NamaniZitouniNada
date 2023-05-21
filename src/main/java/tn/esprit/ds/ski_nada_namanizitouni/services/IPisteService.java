package tn.esprit.ds.ski_nada_namanizitouni.services;

import tn.esprit.ds.ski_nada_namanizitouni.Entities.Piste;

import java.util.List;
import java.util.Optional;

public interface IPisteService {
    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste (Piste piste);
    Optional<Piste>  retrievePiste (Long numPiste);
    void removePiste(Long numPiste);
}
