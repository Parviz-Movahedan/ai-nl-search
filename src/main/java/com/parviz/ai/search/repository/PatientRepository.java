package com.parviz.ai.search.repository;

import com.parviz.ai.search.dto.app.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    Patient findByFirstNameAndLastName(String firstName, String lastName);
}
