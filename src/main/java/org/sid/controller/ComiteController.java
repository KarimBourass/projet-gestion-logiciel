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

    //Utilisateur non authentifié
    @GetMapping(value="/evaluation-articles")
    public List<Article> getArticlesNonEvalue(){
        return comiteService.getArticlesNonEvalue();
    }


    @PostMapping(value="/evaluation-articles/{id}")
    public void affectationArticle(@RequestBody Affectation affectation){
        comiteService.affectationArticle(affectation);
    }


    @PutMapping(value="/decision-articles/{id}")
    public void postDecision(@PathVariable Long id,@RequestBody String decision){
        comiteService.postDecision(id,decision);
    }


    // id == id de l'utilisateur (refree)
    @GetMapping(value="/{id}/refree")
    public List<Affectation> getArticles(@PathVariable Long id){
        return affectationService.getArticlesPourEvaluation(id);
    }

    // id == id de l'utilisateur (refree)
    @PutMapping(value="/{id}/refree")
    public void putEvaluation(@PathVariable Long id,@RequestBody Affectation affectation){
         affectationService.putEvaluation(id,affectation);
    }





}
