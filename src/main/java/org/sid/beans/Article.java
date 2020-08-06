package org.sid.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idArticle;

    private String auteur;

    private String coAuteurs;

    private String title;

    private String affiliations;

    private String resume;

    private String contenu;

    private String decision;

    //en attente  -  en evaluation  -   evalue
    private String etat;

    @OneToMany
    @JoinColumn(name = "article")
    @JsonIgnore
    private Set<MotsCles> motsCles=new HashSet<>();


    @OneToMany(mappedBy="article")
    @JsonIgnore
    private Set<Affectation> affectations=new HashSet<>();



}
