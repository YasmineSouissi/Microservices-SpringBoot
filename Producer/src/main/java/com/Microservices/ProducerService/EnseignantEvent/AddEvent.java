package com.Microservices.ProducerService.EnseignantEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddEvent {
    private Long id_Ens;
    private String nom;
    private String prenom;
    private String email;
    private String grade;

}
