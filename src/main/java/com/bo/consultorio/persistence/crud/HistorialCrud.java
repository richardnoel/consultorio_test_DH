package com.bo.consultorio.persistence.crud;
import com.bo.consultorio.persistence.entity.Historial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistorialCrud  extends CrudRepository<Historial, Integer> {
    Historial findByIdPaciente(int idPaciente);
}
