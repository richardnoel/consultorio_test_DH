package com.bo.consultorio.domain.repository;

import com.bo.consultorio.domain.Doctor;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> getAll();
    Doctor getDoctor(int doctorId);
    Doctor getDoctorByRegisterMed(String doctorId);
    Doctor save(Doctor doctor);
    void delete(int doctorId);
}
