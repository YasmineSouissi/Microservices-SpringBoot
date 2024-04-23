package com.Microservices.ProducerService.Controller;

import com.Microservices.ProducerService.EnseignantEvent.AddEvent;
import com.Microservices.ProducerService.EnseignantEvent.AddEventProducer;
import com.Microservices.ProducerService.Model.Enseignant;
import com.Microservices.ProducerService.Service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
@RestController
@RequestMapping("/enseignant")
public class addController {
    @Autowired
    EnseignantService EnseignantService;

    @Autowired
    AddEventProducer EnseignantEventProducer;

    @PostMapping("/add")
    public ResponseEntity<String> addEnseignant(@Validated @RequestBody Enseignant ens,BindingResult bindingResult) {
        // Vérification des erreurs de validation
        if (bindingResult.hasErrors()) {
            // Renvoyer les erreurs de validation avec un code de réponse approprié
            return ResponseEntity.badRequest().body("Erreur de validation : " + bindingResult.getFieldErrors());
        }

        // Si les données d'entrée sont valides, ajoutez l'enseignant et envoyez l'événement Kafka
        EnseignantService.addNewEnseignant(ens);

        // Création de l'événement AddEvent avec les données de l'enseignant ajouté
        AddEvent EnseignantEvent = new AddEvent();
        EnseignantEvent.setId_Ens(ens.getId_Ens());
        EnseignantEvent.setNom(ens.getNom());
        EnseignantEvent.setPrenom(ens.getPrenom());
        EnseignantEvent.setEmail(ens.getEmail());
        EnseignantEvent.setGrade(ens.getGrade());
        EnseignantEventProducer.sendEvent(EnseignantEvent);

        return ResponseEntity.ok("enseignant added successfully");

    }
}
