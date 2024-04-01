package net.aya.tp3partie1.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
 @NoArgsConstructor @AllArgsConstructor
 @Data
 @Builder //qui permet de construire des objets complexes étape par étape
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;

}
