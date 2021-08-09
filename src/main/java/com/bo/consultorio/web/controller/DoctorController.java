package com.bo.consultorio.web.controller;

import com.bo.consultorio.domain.Doctor;
import com.bo.consultorio.domain.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @GetMapping("/all")
    public List<Doctor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getPatiente(@PathVariable("id") int doctorId) {
        return service.getDoctor(doctorId);
    }

    @PostMapping("/save")
    public Doctor save(@RequestBody Doctor doctor) {
        return service.save(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int doctorId) {
        return service.delete(doctorId);
    }
}
