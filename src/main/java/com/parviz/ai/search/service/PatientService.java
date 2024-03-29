package com.parviz.ai.search.service;

import com.parviz.ai.search.repository.PatientRepository;
import com.parviz.ai.search.dto.app.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    public Patient updatePatient(Patient patient){
        return patientRepository.saveAll(List.of(patient)).get(0);
    }

    public Patient addPatient(Patient patient){
        return patientRepository.insert(patient);
    }

    public void removePatient(String patientId){
        patientRepository.deleteById(patientId);
    }

    public Optional<Patient> findPatient(String patientId){
        return patientRepository.findById(patientId);
    }
}
