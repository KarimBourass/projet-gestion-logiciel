package org.sid.dao;

import org.sid.beans.MotsCles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotsClesRepository extends JpaRepository<MotsCles,Long> {


    @Query(" SELECT a.motsCles from Article a WHERE a.idArticle like :id ")
    List<MotsCles> findMotsClesByArticleId(@Param("id") Long idArticle);


}
