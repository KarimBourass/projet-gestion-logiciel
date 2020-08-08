package org.sid.service;

import org.sid.beans.Affectation;
import org.sid.beans.Article;
import org.sid.dao.AffectationRepository;
import org.sid.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComiteService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private AffectationRepository affectationRepository;



    public List<Article> getArticlesNonEvalue() {
        String etat="en attente";
        System.out.println("hnaaaaa");
        return articleRepository.getArticlesNonEvalue(etat);
    }

    public void affectationArticle(Affectation affectation) {
        affectationRepository.save(affectation);
    }

    public List<Affectation> getAffectation() {
        return affectationRepository.findAll();
    }

    public void postDecision(Long idArticle, String decision) {
        articleRepository.postDecision(idArticle,decision);
    }




}
