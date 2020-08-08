package org.sid.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class MotsCles {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idMotsCles;
    private String motCle;

    @ManyToOne
    @JsonIgnore
    private Article article;




}
