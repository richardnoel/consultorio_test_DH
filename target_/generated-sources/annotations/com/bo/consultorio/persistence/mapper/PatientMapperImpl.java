package com.bo.consultorio.persistence.mapper;

import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.persistence.entity.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-07T16:54:44-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Eclipse Foundation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public Patient toPatient(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientId( paciente.getIdPaciente() );
        patient.setDocumentNumber( paciente.getNumeroDocuemnto() );
        patient.setFirstName( paciente.getNombre() );
        patient.setLastName( paciente.getApellido() );
        patient.setBirthDate( paciente.getFechaNacimiento() );
        patient.setAddress( paciente.getDireccion() );
        patient.setPhoto( paciente.getFoto() );
        patient.setEmail( paciente.getCorreo() );
        patient.setCellNumber( paciente.getCelular() );
        patient.setPhoneNumber( paciente.getTelefono() );

        return patient;
    }

    @Override
    public List<Patient> toPatiens(List<Paciente> pacientes) {
        if ( pacientes == null ) {
            return null;
        }

        List<Patient> list = new ArrayList<Patient>( pacientes.size() );
        for ( Paciente paciente : pacientes ) {
            list.add( toPatient( paciente ) );
        }

        return list;
    }

    @Override
    public Paciente toPaciente(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setIdPaciente( patient.getPatientId() );
        paciente.setNumeroDocuemnto( patient.getDocumentNumber() );
        paciente.setNombre( patient.getFirstName() );
        paciente.setApellido( patient.getLastName() );
        paciente.setFechaNacimiento( patient.getBirthDate() );
        paciente.setDireccion( patient.getAddress() );
        paciente.setFoto( patient.getPhoto() );
        paciente.setCorreo( patient.getEmail() );
        paciente.setCelular( patient.getCellNumber() );
        paciente.setTelefono( patient.getPhoneNumber() );

        return paciente;
    }
}
