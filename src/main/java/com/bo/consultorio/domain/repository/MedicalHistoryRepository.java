package com.bo.consultorio.domain.repository;

import com.bo.consultorio.domain.MedicalHistory;
import com.bo.consultorio.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface MedicalHistoryRepository {
    Optional<MedicalHistory> getById(int idHistory);
    List<MedicalHistory> getAll();
//    Optional<MedicalHistory> getHistorial(int idPaciente);
    MedicalHistory save(MedicalHistory medicalHistory);
    void delete(Integer idHistory);
}
