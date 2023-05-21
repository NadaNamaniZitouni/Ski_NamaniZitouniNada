package tn.esprit.ds.ski_nada_namanizitouni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Skieur;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.TypeAbonnement;
import tn.esprit.ds.ski_nada_namanizitouni.services.ISkieurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("skieur")
public class SkieurController {
    @Autowired
    ISkieurService iSkieurService;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Skieur> getAll(){
        return iSkieurService.retrieveAllSkieurs();

    }
    @GetMapping("{numSkieur}")

    public Optional<Skieur> retrieveSkieur(@PathVariable Long numSkieur) {

        return  iSkieurService.retrieveSkieur(numSkieur);

    }
    @PostMapping

    public Skieur addSkieur(@RequestBody Skieur skieur){

        return iSkieurService.addSkieur(skieur);
    }
    @DeleteMapping("{numSkieur}")
    public void removeSkieur(@PathVariable Long numSkieur){

        iSkieurService.removeSkieur(numSkieur);
    }

    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur Skieur) {

        return  iSkieurService.updateSkieur(Skieur);

    }
    @PutMapping("skiAbon/{numSkieur}/{numAbon}")
    public Skieur AssignSkierToSubscription(@PathVariable Long numSkieur,@PathVariable Long numAbon){
        return iSkieurService.AssignSkierToSubscription(numSkieur,numAbon);
    }
    @GetMapping("typeAbon/{typeAbonnement}")
    public List<Skieur> getSkieurByTypeAbon(@PathVariable TypeAbonnement typeAbonnement){
        return iSkieurService.retrieveSkieurBySubscriptionType(typeAbonnement);
    }
    @PostMapping("/addSkieur")
    Skieur addSkieurAndAssignToCourse(@RequestBody  Skieur skieur){
        return iSkieurService.addSkieurAndAssignToCourse(skieur);
    }

}
