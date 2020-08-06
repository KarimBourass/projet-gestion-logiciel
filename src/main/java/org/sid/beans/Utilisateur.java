package org.sid.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable{


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	@Column(unique=true)
	private String username;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //pour ne pas afficher le mot de passe lors de la retour d'une requete
	private String password;
	@Column(unique=true)
	private String email;


	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Role> roles=new HashSet<>();

	@OneToMany(mappedBy="utilisateur")
	@JsonIgnore
	private Set<Affectation> affectations=new HashSet<>();


}
