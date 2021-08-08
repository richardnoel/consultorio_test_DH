package com.bo.consultorio.persistence;

import com.bo.consultorio.domain.Doctor;
import com.bo.consultorio.domain.repository.DoctorRepository;
import com.bo.consultorio.persistence.crud.DoctorCrud;
import com.bo.consultorio.persistence.entity.DoctorEntity;
import com.bo.consultorio.persistence.entity.Paciente;
import com.bo.consultorio.persistence.mapper.DoctMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorEntityRepository implements DoctorRepository {
    @Autowired
    private DoctorCrud doctorCrud;
    @Autowired
    private DoctMapper mapper;


    @Override
    public List<Doctor> getAll() {
        List<DoctorEntity> doctorEntityList = (List<DoctorEntity>) doctorCrud.findAll();
        return mapper.toDoctorList(doctorEntityList);
    }

    @Override
    public Doctor getDoctor(int doctorId) {
        Doctor doctor = new Doctor();
        try{
           Optional<DoctorEntity> doctorEntityOpt = doctorCrud.findById(doctorId);
           Optional<Doctor> doctorOpt = doctorEntityOpt.map(item -> mapper.toDoctor(item));
            doctor = doctorOpt.get();
            return  doctor;
       }catch (Exception e){
           System.out.println(e);
           return null;
       }
    }

    @Override
    public Doctor getDoctorByRegisterMed(String registerNumber) {
        Doctor doctor = new Doctor();
        try{
            Optional<DoctorEntity> doctorEntityOpt;
            doctorEntityOpt = Optional.ofNullable(doctorCrud.findByRegistroMedico(registerNumber));
            Optional<Doctor> doctorOpt = doctorEntityOpt.map(item -> mapper.toDoctor(item));
            doctor = doctorOpt.get();
            return  doctor;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Doctor save(Doctor doctor) {
        DoctorEntity doctorEntity  = mapper.toDoctorEntity(doctor);
        doctorEntity = doctorCrud.save(doctorEntity);
        return mapper.toDoctor(doctorEntity);
    }

    @Override
    public void delete(int doctorId) {
        doctorCrud.deleteById(doctorId);
    }
}
