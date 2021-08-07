package com.bo.consultorio.persistence.mapper;

import com.bo.consultorio.domain.MedicalHistory;
import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.persistence.entity.Historial;
import com.bo.consultorio.persistence.entity.Paciente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PatientMapper.class})
public interface MedicalHistoryMapper {
    @Mappings({
            @Mapping(source = "idHistorial", target = "idHistory"),
            @Mapping(source = "historal", target = "history")
    })
    MedicalHistory toMedicalHistory(Historial historial);
    List<MedicalHistory> toMedicalHistorys(List<Historial> historialList);

    @InheritInverseConfiguration
    @Mapping(target="fechaCreacion", ignore=true)
    @Mapping(target="creadoPor", ignore=true)
    @Mapping(target="fechaActualizacion", ignore=true)
    @Mapping(target="actualizacionPor", ignore=true)
    @Mapping(target="paciente", ignore=true)
    Historial toHistorial(MedicalHistory medicalHistory);
}
