package com.bo.consultorio.domain.service;

import com.bo.consultorio.domain.Prescription;
import com.bo.consultorio.domain.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository repository;

    public Prescription getPrescription(int prescriptionId) {
        return repository.getPrescription(prescriptionId);
    }

    public List<Prescription> getAll() {
        return repository.getAll();
    }

    public List<Prescription> getByConsultation(int consultationId) {
        return repository.getPrescriptionByConsultation(consultationId);
    }

    public Prescription save(Prescription prescription) {
        return repository.save(prescription);
    }

    public boolean delete(int prescriptionId) {
        Boolean result = false;
        Prescription prescription = repository.getPrescription(prescriptionId);
        if (prescription != null) {
            repository.delete(prescriptionId);
            result = true;
        }
        return result;
    }
}
