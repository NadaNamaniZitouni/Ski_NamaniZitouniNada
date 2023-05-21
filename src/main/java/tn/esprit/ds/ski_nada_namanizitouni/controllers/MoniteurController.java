package tn.esprit.ds.ski_nada_namanizitouni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Monitor;
import tn.esprit.ds.ski_nada_namanizitouni.services.IMoniteurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("moniteur")

public class MoniteurController {
    @Autowired
    IMoniteurService iMoniteurService;
    @GetMapping
    public List<Monitor> getAll(){
        return iMoniteurService.retrieveAllMoniteurs();

    }
    @GetMapping("{numMoniteur}")

    public Optional<Monitor> retrieveMoniteur(@PathVariable Long numMoniteur) {

        return  iMoniteurService.retrieveMoniteur(numMoniteur);

    }
    @PostMapping

    public Monitor addMoniteur(@RequestBody Monitor moniteur){

        return iMoniteurService.addMoniteur(moniteur);
    }
    @DeleteMapping("{numMoniteur}")
    public void removeMoniteur(@PathVariable Long numMoniteur){

        iMoniteurService.removeMoniteur(numMoniteur);
    }

    @PutMapping
    public Monitor updateMoniteur(@RequestBody Monitor Moniteur) {

        return  iMoniteurService.updateMoniteur(Moniteur);

    }
}
