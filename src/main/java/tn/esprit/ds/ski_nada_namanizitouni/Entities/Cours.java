package tn.esprit.ds.ski_nada_namanizitouni.Entities;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cours extends BaseEntity{

    private int niveau;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(EnumType.ORDINAL)
    private Support support;
    private float prix;
    private int creneau;
    @JsonIgnore
    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscriptions;

}

