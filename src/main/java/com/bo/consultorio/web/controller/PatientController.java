package com.bo.consultorio.web.controller;

import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.domain.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService service;
    public List<Patient> getAll(){
       return service.getAll();
    }
    public Optional<Patient> getPatiente(int patientId){
        return service.getPatiente(patientId);
    }
    public List<Patient> getByName(String name){
        return service.getByName(name);
    }
    public Optional<List<Patient>>getBylastName(String lastName){
        return service.getBylastName(lastName);
    }

    public Optional<List<Patient>> getByDocumentNumber(int documentNumber){
        return service.getByDocumentNumber(documentNumber);
    }

    public Patient save(Patient patient){
        return service.save(patient);
    }

    public boolean delete(int patientId){
        return service.delete(patientId);
    }
}
