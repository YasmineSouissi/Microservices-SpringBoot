package com.Microservices.ConsumerService.Service;

import com.Microservices.ConsumerService.AddEvent.AddEvent;
import com.Microservices.ConsumerService.Model.Enseignant;
import com.Microservices.ConsumerService.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;


    public void addEnseignant(AddEvent addEvent) {
        Enseignant enseignant = new Enseignant();
        enseignant.setId_Ens(addEvent.getId_Ens());
        enseignant.setNom(addEvent.getNom());
        enseignant.setPrenom(addEvent.getPrenom());
        enseignant.setMail(addEvent.getEmail());
        enseignant.setGrade(addEvent.getGrade());

        enseignantRepository.save(enseignant);
    }


    public Enseignant getEnseignantById(Long enseignantId) {
        return enseignantRepository.findById(enseignantId)
                .orElseThrow(() -> new IllegalArgumentException("Enseignant not found for ID: " + enseignantId));
    }


    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }


}
