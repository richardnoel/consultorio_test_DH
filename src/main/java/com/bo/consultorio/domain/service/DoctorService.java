package com.bo.consultorio.domain.service;

import com.bo.consultorio.domain.Doctor;
import com.bo.consultorio.domain.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getDoctor(int doctorId) {
        return doctorRepository.getDoctor(doctorId);
    }

    public List<Doctor> getAll() {
        return doctorRepository.getAll();
    }

    public Doctor getDoctorByRegisterMed(String doctorRegister) {
        return doctorRepository.getDoctorByRegisterMed(doctorRegister);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public boolean delete(int doctorId) {
        Boolean result = false;
        Doctor doctor = new Doctor();
        doctor = doctorRepository.getDoctor(doctorId);
        if (doctor != null) {
            doctorRepository.delete(doctorId);
            result = true;
        }
        return result;
    }

}
