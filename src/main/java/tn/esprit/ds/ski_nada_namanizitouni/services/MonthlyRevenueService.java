package tn.esprit.ds.ski_nada_namanizitouni.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.Abonnement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Service
public class MonthlyRevenueService {

    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(cron = "0 0 0 1 * *") // Run at midnight on the first day of each month
    /*"0 0 0" represents the time of day (hour, minute, and second) when the method should run, in 24-hour format. In this case, it's midnight (00:00:00).
"1" represents the day of the month on which the method should run. In this case, it's the first day of the month.
"*" represents the other fields in the cron expression, which are the month, day of the week, and year. The asterisk means "any value", so the method will run regardless of the month, day of the week, or year.*/
    public void showMonthlyRecurringRevenue() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);

        List<Abonnement> abonnements = entityManager.createQuery("SELECT a FROM Abonnement a WHERE a.dateDebut <= :oneMonthAgo AND a.dateFin >= :today", Abonnement.class)
                .setParameter("oneMonthAgo", oneMonthAgo)
                .setParameter("today", today)
                .getResultList();

        float revenue = 0;
        for (Abonnement abonnement : abonnements) {
            revenue += abonnement.getPrixAbon();
        }

        System.out.println("Monthly recurring revenue for " + oneMonthAgo.getMonth() + " is " + revenue);
    }
}
