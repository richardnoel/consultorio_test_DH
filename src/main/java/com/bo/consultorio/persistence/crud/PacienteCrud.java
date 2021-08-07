package com.bo.consultorio.persistence.crud;

import com.bo.consultorio.persistence.entity.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteCrud extends CrudRepository<Paciente, Integer> {
//    @Query(value = "SELECT * FROM paciente WHERE nombre = ?", nativeQuery = true)
    List<Paciente> findByNombreOrderByNombreAsc(String nombre);
    List<Paciente> findByApellidoOrderByApellidoAsc(String apellido);
    List<Paciente> findByNumeroDocuemnto(int numeroDocuemnto);

}
