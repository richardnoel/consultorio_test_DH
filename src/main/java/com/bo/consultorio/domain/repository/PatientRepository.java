package com.bo.consultorio.domain.repository;

import com.bo.consultorio.domain.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    List<Patient> getAll();
    Optional<Patient> getPatien(int patientId);
    List<Patient> getByName(String name);
    Optional<List<Patient>> getByLastName(String lastName);
    Optional<List<Patient>> getByDocumentNumber(int documentNumber);
    Patient save(Patient patient);
    void delete(int patientId);
}
