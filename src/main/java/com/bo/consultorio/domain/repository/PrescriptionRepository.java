package com.bo.consultorio.domain.repository;

import com.bo.consultorio.domain.Prescription;

import java.util.List;

public interface PrescriptionRepository {
    Prescription getPrescription(int prescriptionId);
    List<Prescription> getAll();
    List<Prescription> getPrescriptionByConsultation(int consultationId);
    Prescription save(Prescription prescription);
    void delete(int prescriptionId);
}
