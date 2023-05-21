package tn.esprit.ds.ski_nada_namanizitouni.Entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skieur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaiss;
    private String ville;

    @OneToMany(mappedBy = "skieur", cascade= CascadeType.REMOVE)
    public List<Inscription> inscription;

    @ManyToMany
    public List<Piste> piste;

    @OneToOne(cascade = CascadeType.REMOVE)
    public Abonnement abonnement;
}
