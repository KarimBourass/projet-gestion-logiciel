package org.sid.dao;

import org.sid.beans.Article;
import org.sid.beans.MotsCles;
import org.sid.beans.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query(value = "SELECT a from Article a WHERE a.decision like :dec ")
    List<Article> getPublicArticles(@Param("dec") String dec);

    @Query(" SELECT a.etat from Article a WHERE a.idArticle like :id ")
    String findEtatById(@Param("id")Long id);

    @Query(value = "SELECT a from Article a WHERE a.etat like :etat")
    List<Article> getArticlesNonEvalue(@Param("etat")String etat);


    @Query(" SELECT a from Article a WHERE a.idArticle like :id ")
    Article getEtatArticle(@Param("id")Long id);

    @Transactional
    @Modifying
    @Query(" update Article a set a.decision=:decision where a.idArticle like :id ")
    void postDecision(@Param("id")Long idArticle,@Param("decision") String decision);

    @Query(value = "SELECT a from Article a WHERE a.decision = 'accepte' AND a.auteur like :auteur")
    List<Article> getPublicArticlesAuteur(@Param("auteur")String auteur);



}
