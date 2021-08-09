package com.bo.consultorio.web.controller;

import com.bo.consultorio.domain.MedicalHistory;
import com.bo.consultorio.domain.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/history")
public class MedicalHIstoryController {
    @Autowired
    private MedicalHistoryService service;

    @GetMapping("/all")
    public List<MedicalHistory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MedicalHistory> getMedicalHistory(@PathVariable("id") int idHistory) {
        return service.getMedicalHistory(idHistory);
    }

    @GetMapping("/patient/{patientId}")
    public Optional<List<MedicalHistory>> getByPatient(@PathVariable("patientId") int patientId) {
        return service.getByPatient(patientId);
    }

    @PostMapping("/save")
    public MedicalHistory save(MedicalHistory medicalHistory) {
        return service.save(medicalHistory);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int idHistory) {
        return service.delete(idHistory);
    }
}
