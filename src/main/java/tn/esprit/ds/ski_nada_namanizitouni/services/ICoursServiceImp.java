package tn.esprit.ds.ski_nada_namanizitouni.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Cours;
import tn.esprit.ds.ski_nada_namanizitouni.repositories.CoursRepository;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class ICoursServiceImp implements ICoursService{

    @Autowired
    CoursRepository coursRepository;
    @Override
    public List<Cours> retrieveAllCours() {
        return  coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);    }

    @Override
    public Optional<Cours> retrieveCours(Long numCours) {
        return coursRepository.findById(numCours);
    }

    @Override
    public void removeCours(Long numCours) {
        log.info("in removeCours");
        coursRepository.deleteById(numCours);

    }

    @Scheduled(fixedDelay = 60000)
    @Scheduled(fixedRate = 60000)
    @Scheduled(cron = "0 0 0 * * MON-FRI")
    @Override
    public void test() {

        log.info("4 ds 4 hello world");

    }
}
