package com.bo.consultorio.persistence.mapper;
import com.bo.consultorio.domain.Doctor;
import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.persistence.entity.DoctorEntity;
import com.bo.consultorio.persistence.entity.Paciente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctMapper {
    @Mappings({
            @Mapping(source="idDoctor", target="doctorId"),
            @Mapping(source="nombre", target="firstName"),
            @Mapping(source="apellido", target="lastName"),
            @Mapping(source="fechaNacimiento", target="birthDate"),
            @Mapping(source="especialidad", target="speciality"),
            @Mapping(source="direccion", target="address"),
            @Mapping(source="foto", target="photo"),
            @Mapping(source="registroMedico", target="medicalRegister"),
            @Mapping(source="correo", target="email"),
            @Mapping(source="celular", target="cellNumber"),
            @Mapping(source="telefono", target="phoneNumber")
    })
    Doctor toDoctor(DoctorEntity doctorEntity);
    List<Doctor> toDoctorList(List<DoctorEntity> doctorEntityList);

    @InheritInverseConfiguration
    @Mapping(target="fechaCreacion", ignore=true)
    @Mapping(target="creadoPor", ignore=true)
    @Mapping(target="fechaActualizacion", ignore=true)
    @Mapping(target="actualizacionPor", ignore=true)
    DoctorEntity toDoctorEntity(Doctor doctor);
}
