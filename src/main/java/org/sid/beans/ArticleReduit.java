package org.sid.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor      @NoArgsConstructor
public class ArticleReduit {

    private Long idArticleReduit;

    private String auteur;

    private String coAuteurs;

    private String title;

    private String resume;

    private List<MotsCles> motsClesList;
}
