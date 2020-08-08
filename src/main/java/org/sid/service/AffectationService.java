package org.sid.service;

import org.sid.beans.Affectation;
import org.sid.dao.AffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffectationService {

    @Autowired
    private AffectationRepository affectationRepository;


    public List<Affectation> getArticlesPourEvaluation(Long id) {
      return affectationRepository.getArticlesPourEvaluation(id);
    }

    public void putEvaluation(Long id, Affectation affectation) {

        Long idAffectation=affectation.getIdAffectation();
        String evaluation=affectation.getEvaluation();
        String commentaire=affectation.getCommentaire();

        affectationRepository.putEvaluation(idAffectation,evaluation,commentaire);

    }


}
