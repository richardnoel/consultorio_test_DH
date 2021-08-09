package com.bo.consultorio.web.controller;

import com.bo.consultorio.domain.Prescription;
import com.bo.consultorio.domain.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService service;

    @GetMapping("/all")
    public List<Prescription> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Prescription get(@PathVariable("id") int prescriptionId) {
        return service.getPrescription(prescriptionId);
    }

    @GetMapping("/consultation/{id}")
    public List<Prescription> getByConsultation(@PathVariable("id") int cosultationId) {
        return service.getByConsultation(cosultationId);
    }

    @PostMapping("/save")
    public Prescription save(@RequestBody Prescription prescription) {
        return service.save(prescription);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int prescriptionId) {
        return service.delete(prescriptionId);
    }

}
