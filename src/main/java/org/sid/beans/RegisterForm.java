package org.sid.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class RegisterForm {
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String username;
	private String password;
	private String repassword;
	private String email;

	
	

}
