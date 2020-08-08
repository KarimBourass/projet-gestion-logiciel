package org.sid.service;

import org.sid.beans.Article;
import org.sid.beans.ArticleReduit;
import org.sid.beans.MotsCles;
import org.sid.dao.ArticleRepository;
import org.sid.dao.MotsClesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private MotsClesRepository motsClesRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findByAuteur(Long id) {
        return articleRepository.findById(id);
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }


    //Pour savoir si l'article est en cours d'evaluation ou non
    public boolean checkEtat(Long id) {
        String etat = articleRepository.findEtatById(id);
        if (etat != "en attente") {
            return false;
        } else {
            return true;
        }
    }

    public void updateArticle(Long id, Article article) {
        boolean etat = checkEtat(id);
        if (etat == true)
             articleRepository.save(article);
    }

    public void deleteById(Long id) {

        boolean etat = checkEtat(id);
        if (etat == true) {
            articleRepository.deleteById(id);
        }

    }



    public List<Article> getPrivateArticles() {
        return articleRepository.findAll();
    }


    public Article getEtatArticle(Long id) {
        return articleRepository.getEtatArticle(id);
    }

    public List<ArticleReduit> getPublicArticlesParMotCLe(String motCle) {
        if(motCle==""){
            return getPublicArticles();
        }else {
            return getPublicArticlesMotcLe(motCle);

        }
    }

    public List<ArticleReduit> getPublicArticlesParAuteur(String auteur) {
        if(auteur==""){
            return getPublicArticles();
        }else {
            return getPublicArticlesAuteur(auteur);
        }
    }

    public List<ArticleReduit> getPublicArticles() {

        String decision="accepte";
        List<Article> articles=articleRepository.getPublicArticles(decision);
        List<ArticleReduit> articleReduits=new ArrayList<>();

        for (Article article:articles) {
            ArticleReduit articleReduit=new ArticleReduit();
            articleReduit.setIdArticleReduit(article.getIdArticle());
            articleReduit.setTitle(article.getTitle());
            articleReduit.setAuteur(article.getAuteur());
            articleReduit.setCoAuteurs(article.getCoAuteurs());
            articleReduit.setResume(article.getResume());
            articleReduit.setMotsClesList(motsClesRepository.findMotsClesByArticleId(article.getIdArticle()));

            articleReduits.add(articleReduit);
        }
        return articleReduits;
    }

    private List<ArticleReduit> getPublicArticlesAuteur(String auteur) {

        List<Article> articles=articleRepository.getPublicArticlesAuteur(auteur);
        List<ArticleReduit> articleReduits=new ArrayList<>();

        for (Article article:articles) {
            ArticleReduit articleReduit=new ArticleReduit();
            articleReduit.setIdArticleReduit(article.getIdArticle());
            articleReduit.setTitle(article.getTitle());
            articleReduit.setAuteur(article.getAuteur());
            articleReduit.setCoAuteurs(article.getCoAuteurs());
            articleReduit.setResume(article.getResume());
            articleReduit.setMotsClesList(motsClesRepository.findMotsClesByArticleId(article.getIdArticle()));

            articleReduits.add(articleReduit);
        }
        return articleReduits;
    }

    public List<ArticleReduit> getPublicArticlesMotcLe(String motCle) {

        List<Article> articles= motsClesRepository.findArticlesByMotCle(motCle);

        List<ArticleReduit> articleReduits=new ArrayList<>();

        for (Article article:articles) {
            ArticleReduit articleReduit=new ArticleReduit();
            articleReduit.setIdArticleReduit(article.getIdArticle());
            articleReduit.setTitle(article.getTitle());
            articleReduit.setAuteur(article.getAuteur());
            articleReduit.setCoAuteurs(article.getCoAuteurs());
            articleReduit.setResume(article.getResume());
            articleReduit.setMotsClesList(motsClesRepository.findMotsClesByArticleId(article.getIdArticle()));

            articleReduits.add(articleReduit);
        }
        return articleReduits;
    }



}
