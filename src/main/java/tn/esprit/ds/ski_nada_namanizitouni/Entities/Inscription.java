package tn.esprit.ds.ski_nada_namanizitouni.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int numInscription;
   private int numSemaine;
   @ManyToOne
   public Cours cours;
   @JsonIgnore
   @ManyToOne
    public Skieur skieur;
}
