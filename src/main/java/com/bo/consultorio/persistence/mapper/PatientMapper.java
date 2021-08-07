package com.bo.consultorio.persistence.mapper;

import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.persistence.entity.Paciente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mappings({
            @Mapping(source = "idPaciente", target = "patientId"),
            @Mapping(source = "numeroDocuemnto", target = "documentNumber"),
            @Mapping(source = "nombre", target = "firstName"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "fechaNacimiento", target = "birthDate"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "foto", target = "photo"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "celular", target = "cellNumber"),
            @Mapping(source = "telefono", target = "phoneNumber")
    })
    Patient toPatient(Paciente paciente);
    List<Patient> toPatiens(List<Paciente> pacientes);

    @InheritInverseConfiguration
    @Mapping(target="fechaCreacion", ignore=true)
    @Mapping(target="creadoPor", ignore=true)
    @Mapping(target="fechaActualizacion", ignore=true)
    @Mapping(target="actualizacionPor", ignore=true)
    Paciente toPaciente(Patient patient);
}
