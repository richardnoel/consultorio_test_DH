package com.bo.consultorio.persistence.crud;

import com.bo.consultorio.persistence.entity.Consulta;
import com.bo.consultorio.persistence.entity.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

public interface ConsultaCrud extends CrudRepository<Consulta, Integer> {
    //Consulta findByRegistroMedico(String registroMedico);
}
