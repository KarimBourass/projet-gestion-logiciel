package org.sid.dao;

import org.sid.beans.Comite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComiteRepository extends JpaRepository<Comite,Long> {
}
