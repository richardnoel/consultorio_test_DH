package com.bo.consultorio.domain.service;

import com.bo.consultorio.domain.MedicalHistory;
import com.bo.consultorio.domain.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoryService {
    @Autowired
    private MedicalHistoryRepository historyRepository;

    public  Optional<MedicalHistory> getMedicalHistory(int idHistory){
        return historyRepository.getHistory(idHistory);
    }

    public  List<MedicalHistory> getAll(){
        return historyRepository.getAll();
    }

    public Optional<List<MedicalHistory>> getByPatient(int patientId){
        return historyRepository.getByPatient(patientId);
    }

    public MedicalHistory save(MedicalHistory medicalHistory){
        return historyRepository.save(medicalHistory);
    }

    public boolean delete(int idHistory){
        return getMedicalHistory(idHistory).map(medicalHistory -> {
            historyRepository.delete(idHistory);
            return true;
        }).orElse(false);
    }
}
