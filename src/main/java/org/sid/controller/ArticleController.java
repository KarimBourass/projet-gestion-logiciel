package org.sid.controller;

import org.sid.beans.Article;
import org.sid.beans.ArticleReduit;
import org.sid.dao.AffectationRepository;
import org.sid.service.AffectationService;
import org.sid.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AffectationService affectationService;

    //Utilisateur non authentifié
    //This is a public API
    @GetMapping(value="/articles-public/mot-cle")
    public List<ArticleReduit> getPublicArticlesParMotCLe(@RequestParam(value = "motCle") String motCle){
        return articleService.getPublicArticlesParMotCLe(motCle);
    }

    @GetMapping(value="/articles-public/auteur ")
    public List<ArticleReduit> getPublicArticlesParAuteur(@RequestParam(value = "auteur")  String auteur){
        return articleService.getPublicArticlesParAuteur(auteur);
    }



    //Utilisateur authentifié
    @GetMapping(value="/articles-prive")
    public List<Article> getPrivateArticles(){
        return articleService.getPrivateArticles();
    }

    //Pour enregistrer des articles
    @PostMapping(value = "articles")
    public void postArticle(@RequestBody Article article){  articleService.save(article);}

    //Pour supprimer des articles
    @DeleteMapping(value="/articles/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteById(id);
    }

    //Pour modifier des articles
    @PutMapping(value="/articles/{id}")
    public void updateArticle(@PathVariable Long id,@RequestBody Article article){
        article.setIdArticle(id);
         articleService.updateArticle(id,article);
    }

    @GetMapping(value="/articles/{id}")
    public Article getEtatArticle(@PathVariable Long id){
        return articleService.getEtatArticle(id);
    }







}
