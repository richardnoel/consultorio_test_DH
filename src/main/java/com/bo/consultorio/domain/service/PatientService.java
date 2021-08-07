package com.bo.consultorio.domain.service;

import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.domain.repository.PatientRepository;
import com.bo.consultorio.persistence.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAll(){
        return patientRepository.getAll();
    }
    public Optional<Patient> getPatiente(int patientId){
        return patientRepository.getPatien(patientId);
    }
    public List<Patient> getByName(String name){
        return patientRepository.getByName(name);
    }
    public Optional<List<Patient>>getBylastName(String lastName){
        return patientRepository.getByLastName(lastName);
    }

    public Optional<List<Patient>> getByDocumentNumber(int documentNumber){
        return patientRepository.getByDocumentNumber(documentNumber);
    }

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public boolean delete(int patientId){
        return getPatiente(patientId).map(patient -> {
            patientRepository.delete(patientId);
            return true;
        }).orElse(false);
    }

}
