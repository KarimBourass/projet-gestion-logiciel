package org.sid.dao;

import org.sid.beans.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AffectationRepository extends JpaRepository<Affectation,Long> {

    @Query(" SELECT af from Affectation af WHERE af.article.idArticle like :id ")
    List<Affectation> getArticlesPourEvaluation(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(" update Affectation af set af.commentaire=:comm,af.evaluation=:evaluation  where af.idAffectation like :id ")
    void putEvaluation(@Param("id")Long idAffectation,@Param("evaluation") String evaluation,@Param("comm") String commentaire);
}
