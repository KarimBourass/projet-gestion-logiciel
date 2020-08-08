package org.sid.dao;

import org.sid.beans.Article;
import org.sid.beans.MotsCles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MotsClesRepository extends JpaRepository<MotsCles,Long> {


    @Query(" SELECT a.motsCles from Article a WHERE a.idArticle like :id ")
    List<MotsCles> findMotsClesByArticleId(@Param("id") Long idArticle);

    @Query(" SELECT mc.article from MotsCles mc WHERE mc.motCle like :motCl ")
    List<Article> findArticlesByMotCle(@Param("motCl") String motCl);


}
