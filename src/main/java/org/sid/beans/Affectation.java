package org.sid.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Affectation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAffectation;
    private String commentaire;
    private String etat;
    private String evaluation;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Utilisateur utilisateur;






}
