package com.bo.consultorio.domain.service;

import com.bo.consultorio.domain.MedicalConsultation;
import com.bo.consultorio.domain.repository.MedicalConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalConsultationService {

    @Autowired
    private MedicalConsultationRepository repository;

    public MedicalConsultation getMedicalConsultation(int consultationId) {
        return repository.getMedicalConsultation(consultationId);
    }

    public List<MedicalConsultation> getAll() {
        return repository.getAll();
    }
    
    public MedicalConsultation save(MedicalConsultation consultation) {
        return repository.save(consultation);
    }

    public boolean delete(int consultationId) {
        Boolean result = false;
        MedicalConsultation consultation = new MedicalConsultation();
        consultation = repository.getMedicalConsultation(consultationId);
        if (consultation != null) {
            repository.delete(consultationId);
            result = true;
        }
        return result;
    }
}
