package com.bo.consultorio.web.controller;

import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.domain.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping("/all")
    public List<Patient> getAll(){
       return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatiente(@PathVariable("id") int patientId){
        return service.getPatiente(patientId);
    }

    @GetMapping("/name/{firstName}")
    public List<Patient> getByName(@PathVariable("firstName") String name){
        return service.getByName(name);
    }

    @GetMapping("/lastName/{lastName}")
    public Optional<List<Patient>>getBylastName(@PathVariable("lastName") String lastName){
        return service.getBylastName(lastName);
    }

    @GetMapping("/document/{document}")
    public Optional<List<Patient>> getByDocumentNumber(@PathVariable("document") int documentNumber){
        return service.getByDocumentNumber(documentNumber);
    }

    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient){
        return service.save(patient);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id")  int patientId){
        return service.delete(patientId);
    }

}
