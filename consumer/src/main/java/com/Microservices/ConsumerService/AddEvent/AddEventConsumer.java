package com.Microservices.ConsumerService.AddEvent;

import com.Microservices.ConsumerService.Model.Enseignant;
import com.Microservices.ConsumerService.Service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AddEventConsumer {
    private final EnseignantService enseignantService;

    @Autowired
    public AddEventConsumer(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAddEvent(AddEvent addEvent) {
        System.out.println("\nAdd event received => " + addEvent);
        try {
            enseignantService.addEnseignant(addEvent);
            System.out.println("enseingnat ajouté");
            Enseignant enseignant = enseignantService.getEnseignantById(addEvent.getEnseignantId());
            System.out.println("==> Enseignant récupéré avec succès: " + enseignant);
        } catch (IllegalArgumentException e) {
            System.out.printf("==> Error retrieving enseignant details for enseignantId: %s. Reason: %s", addEvent.getEnseignantId(), e.getMessage());
        } catch (Exception e) {
            System.out.println("==> An unexpected error occurred while retrieving enseignant details for enseignantId: " + addEvent.getEnseignantId() + e);
        }
    }
}
