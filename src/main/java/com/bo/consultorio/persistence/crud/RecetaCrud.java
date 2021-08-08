package com.bo.consultorio.persistence.crud;

import com.bo.consultorio.persistence.RecetaRepository;
import com.bo.consultorio.persistence.entity.Receta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecetaCrud extends CrudRepository<Receta, Integer> {
    List<Receta> findByIdConsulta(int idConsulta);
}
