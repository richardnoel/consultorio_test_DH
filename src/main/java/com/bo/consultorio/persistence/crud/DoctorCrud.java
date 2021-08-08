package com.bo.consultorio.persistence.crud;

import com.bo.consultorio.persistence.entity.DoctorEntity;
import com.bo.consultorio.persistence.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorCrud extends CrudRepository<DoctorEntity, Integer> {
    DoctorEntity findByRegistroMedico(String registroMedico);
}
