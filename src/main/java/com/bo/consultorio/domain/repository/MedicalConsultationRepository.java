package com.bo.consultorio.domain.repository;

import com.bo.consultorio.domain.Doctor;
import com.bo.consultorio.domain.MedicalConsultation;

import java.util.List;

public interface MedicalConsultationRepository {
    List<MedicalConsultation> getAll();
    MedicalConsultation getMedicalConsultation(int consultationId);
    MedicalConsultation save(MedicalConsultation consultation);
    void delete(int consultationId);
}
