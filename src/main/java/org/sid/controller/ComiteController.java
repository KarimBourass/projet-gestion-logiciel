package org.sid.controller;

import org.sid.beans.Affectation;
import org.sid.beans.Article;
import org.sid.beans.Utilisateur;
import org.sid.service.AffectationService;
import org.sid.service.ComiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/comite")
@CrossOrigin
public class ComiteController {

    @Autowired
    private ComiteService comiteService;

    @Autowired
    private AffectationService affectationService;

    @GetMapping(value="/evaluation-articles")
    public List<Article> getArticlesNonEvalue(){
        return comiteService.getArticlesNonEvalue();
    }


    @PostMapping(value="/affectattion/{id}")
    public void affectationArticle(@PathVariable Long id,@RequestBody Affectation affectation){
        comiteService.affectationArticle(affectation);
    }


    @PutMapping(value="/decision/{id}")
    public void postDecision(@PathVariable Long id,@RequestBody String decision){
        comiteService.postDecision(id,decision);
    }


    // id == id de l'utilisateur (refree)
    @GetMapping(value="/refree/{id}")
    public List<Affectation> getArticles(@PathVariable Long id){
        return affectationService.getArticlesPourEvaluation(id);
    }

    // id == id de l'utilisateur (refree)
    @PutMapping(value="/refree/{id}")
    public void putEvaluation(@PathVariable Long id,@RequestBody Affectation affectation){
         affectationService.putEvaluation(id,affectation);
    }





}
