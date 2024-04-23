package com.Microservices.ProducerService.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Enseignant")

public class Enseignant {
    @Id
    @Column(name = "id_Ens")
    private Long id_Ens;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "grade")
    private String grade;

}
