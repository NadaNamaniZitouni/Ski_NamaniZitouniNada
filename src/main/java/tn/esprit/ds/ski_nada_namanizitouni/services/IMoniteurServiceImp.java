package tn.esprit.ds.ski_nada_namanizitouni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Monitor;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Cours;
import tn.esprit.ds.ski_nada_namanizitouni.repositories.CoursRepository;
import tn.esprit.ds.ski_nada_namanizitouni.repositories.MoniteurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IMoniteurServiceImp implements IMoniteurService{

    @Autowired
    MoniteurRepository moniteurRepository;
    CoursRepository coursRepository;
    @Override
    public List<Monitor> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Monitor addMoniteur(Monitor moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Monitor updateMoniteur(Monitor moniteur) {
        return moniteurRepository.save(moniteur);    }

    @Override
    public Optional<Monitor> retrieveMoniteur(Long numMonitor) {

        return moniteurRepository.findById(numMonitor);
    }

    @Override
    public void removeMoniteur(Long numMonitor) {
        moniteurRepository.deleteById(numMonitor);

    }
    @Override
    public Monitor addInstructorAndAssignToCourse(Monitor moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        List<Monitor> allMoniteurs = moniteurRepository.findAll();
        if(moniteur != null && cours != null){
            List<Cours> coursList = allMoniteurs.get(0).getCours();
            coursList.add(cours);
            moniteur.setCours(coursList);
            return moniteurRepository.save(moniteur);
        }
        return null;
    }
}
