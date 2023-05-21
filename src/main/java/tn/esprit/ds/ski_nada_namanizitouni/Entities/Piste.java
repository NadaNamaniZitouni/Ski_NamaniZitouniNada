package tn.esprit.ds.ski_nada_namanizitouni.Entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Piste {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long numPiste;
    private String nomPiste;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int pente;
    private int longueur;

    @ManyToMany(mappedBy = "piste" )
    public List<Skieur> Skieur;

}
