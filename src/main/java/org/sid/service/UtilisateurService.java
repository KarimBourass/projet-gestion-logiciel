package org.sid.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.sid.beans.Role;
import org.sid.beans.Utilisateur;
import org.sid.dao.RoleRepository;
import org.sid.dao.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UtilisateurService{

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;

	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();

	}

	public Optional<Utilisateur> findById(Long id) {
		return utilisateurRepository.findById(id);

	}

	public void deleteById(Long id) {
		utilisateurRepository.deleteById(id);

	}

	public Utilisateur saveUtilisateur(Utilisateur user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return utilisateurRepository.save(user);
	}

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	public void AddRoleToUser(String username,String roleName) {
		Role role=roleRepository.findByNomRole(roleName);
		Utilisateur user=utilisateurRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	public Utilisateur findUserByUsername(String username) {
		return utilisateurRepository.findByUsername(username);
	}

	public Utilisateur loadCurrentUser(String username) {
		return utilisateurRepository.loadCurrentUser(username);
	}

	public Utilisateur findByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}


	public List<Utilisateur> chercherUtilisateur(String nom){
		return utilisateurRepository.chercherUtilisateur("%"+nom+"%");
	}


}
