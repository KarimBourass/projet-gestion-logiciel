package org.sid.dao;

import org.sid.beans.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

	public Role findByNomRole(String nomRole);

}
