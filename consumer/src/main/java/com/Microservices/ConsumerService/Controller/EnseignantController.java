package com.Microservices.ConsumerService.Controller;

import com.Microservices.ConsumerService.Model.Enseignant;
import com.Microservices.ConsumerService.Service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;
    @GetMapping("/all")
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        if (!enseignants.isEmpty()) {
            return ResponseEntity.ok(enseignants);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}