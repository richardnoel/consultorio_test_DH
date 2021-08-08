package com.bo.consultorio.domain.repository;

import com.bo.consultorio.domain.MedicalHistory;
import java.util.List;
import java.util.Optional;

public interface MedicalHistoryRepository {
    Optional<MedicalHistory> getHistory(int idHistory);
    List<MedicalHistory> getAll();
    Optional<List<MedicalHistory>>  getByPatient(int idPaciente);
    MedicalHistory save(MedicalHistory medicalHistory);
    void delete(Integer idHistory);
}
