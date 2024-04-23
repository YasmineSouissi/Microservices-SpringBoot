package com.Microservices.ProducerService.Repository;

import com.Microservices.ProducerService.Model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository <Enseignant, String> {
}
