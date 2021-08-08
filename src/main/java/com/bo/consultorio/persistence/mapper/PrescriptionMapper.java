package com.bo.consultorio.persistence.mapper;

import com.bo.consultorio.domain.Prescription;
import com.bo.consultorio.persistence.entity.Receta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MedicalConsultationMapper.class})
public interface PrescriptionMapper {
    @Mappings({
            @Mapping(source = "idReceta", target = "prescriptionId"),
            @Mapping(source = "dosis", target = "description"),
            @Mapping(source = "idConsulta", target = "consultationId"),
            @Mapping(source = "consulta", target = "consultation")
    })
    Prescription toPrescription(Receta receta);

    List<Prescription> toPrescriptionList(List<Receta> recetaList);

    @InheritInverseConfiguration
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "creadoPor", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    @Mapping(target = "actualizacionPor", ignore = true)
    Receta toReceta(Prescription prescription);
}
