package com.bo.consultorio.persistence.mapper;

import com.bo.consultorio.domain.Doctor;
import com.bo.consultorio.domain.MedicalConsultation;
import com.bo.consultorio.persistence.entity.Consulta;
import com.bo.consultorio.persistence.entity.DoctorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicalConsultationMapper {
    @Mappings({
            @Mapping(source = "idConsulta", target="consultationId"),
            @Mapping(source = "idDoctor", target = "doctorId"),
            @Mapping(source = "idPaciente", target = "patientId"),
            @Mapping(source = "fecha", target="date")
    })
    MedicalConsultation toMedicalConsultation(Consulta consulta);
    List<MedicalConsultation> toMedicalConsultationList(List<Consulta> consultaList);

    @InheritInverseConfiguration
    @Mapping(target="fechaCreacion", ignore=true)
    @Mapping(target="creadoPor", ignore=true)
    @Mapping(target="fechaActualizacion", ignore=true)
    @Mapping(target="actualizacionPor", ignore=true)

    Consulta toConsulta(MedicalConsultation consultation);
}
