package com.bo.consultorio.persistence.crud;

import com.bo.consultorio.persistence.entity.Consulta;
import com.bo.consultorio.persistence.entity.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultaCrud extends CrudRepository<Consulta, Integer> {
    List<Consulta> findByIdDoctor(int idDoctor);
}
