package org.sid.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor     @NoArgsConstructor
public class Comite implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idComite;
    private String nomComite;

    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Utilisateur> utilisateurs=new HashSet<>();

}
