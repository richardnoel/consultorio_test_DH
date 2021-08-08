package com.bo.consultorio.web.controller;

import com.bo.consultorio.domain.MedicalConsultation;
import com.bo.consultorio.domain.service.MedicalConsultationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultaController {
    @Autowired
    private MedicalConsultationService service;

    @ApiOperation("Get all Medical Consultation")
    @GetMapping("/all")
    public List<MedicalConsultation> getAll() {
        return service.getAll();
    }

    @ApiOperation("Get Medical Consultation by Id consulting")
    @GetMapping("/{id}")
    public MedicalConsultation get(@PathVariable("id") int consultationId) {
        return service.getMedicalConsultation(consultationId);
    }

    @ApiOperation("Get Consulting by Doctor")
    @GetMapping("/doctor/{id}")
    public List<MedicalConsultation> getByDoctor(@PathVariable("id") int doctorId) {
        return service.getByDoctor(doctorId);
    }

    @ApiOperation("Get Consulting by Patient")
    @GetMapping("/patient/{id}")
    public List<MedicalConsultation> getByPatient(@PathVariable("id") int patientId) {
        return service.getByPatient(patientId);
    }

    @ApiOperation("Save a new Consultation")
    @PostMapping("/save")
    public MedicalConsultation save(@RequestBody MedicalConsultation consultation) {
        return service.save(consultation);
    }

    @ApiOperation("Remove a consultation by id")
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int consultationId) {
        return service.delete(consultationId);
    }
}
