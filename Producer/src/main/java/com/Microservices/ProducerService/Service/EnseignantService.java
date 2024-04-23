package com.Microservices.ProducerService.Service;
import com.Microservices.ProducerService.Model.Enseignant;
import com.Microservices.ProducerService.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Transactional
public class EnseignantService {
    private static final Logger logger = LogManager.getLogger(EnseignantService.class);

    @Autowired
    EnseignantRepository ensRepository;

    public void addNewEnseignant(Enseignant enseignant) {
        logger.info("Ajout d'un nouvel enseignant : {}", enseignant);
        ensRepository.save(enseignant);
    }
}
