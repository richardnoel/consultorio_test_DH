package com.bo.consultorio.web.controller;

import com.bo.consultorio.domain.MedicalConsultation;
import com.bo.consultorio.domain.service.MedicalConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultaController {
    @Autowired
    private MedicalConsultationService service;

    @GetMapping("/all")
    public List<MedicalConsultation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MedicalConsultation get(@PathVariable("id") int consultationId) {
        return service.getMedicalConsultation(consultationId);
    }

    @PostMapping("/save")
    public MedicalConsultation save(@RequestBody MedicalConsultation consultation) {
        return service.save(consultation);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int consultationId) {
        return service.delete(consultationId);
    }
}
