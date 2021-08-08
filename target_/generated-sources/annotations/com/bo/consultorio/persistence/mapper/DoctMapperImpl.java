package com.bo.consultorio.persistence.mapper;

import com.bo.consultorio.domain.Doctor;
import com.bo.consultorio.persistence.entity.DoctorEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-07T22:54:00-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Eclipse Foundation)"
)
@Component
public class DoctMapperImpl implements DoctMapper {

    @Override
    public Doctor toDoctor(DoctorEntity doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setDoctorId( doctorEntity.getIdDoctor() );
        doctor.setFirstName( doctorEntity.getNombre() );
        doctor.setLastName( doctorEntity.getApellido() );
        doctor.setBirthDate( doctorEntity.getFechaNacimiento() );
        doctor.setSpeciality( doctorEntity.getEspecialidad() );
        doctor.setAddress( doctorEntity.getDireccion() );
        doctor.setPhoto( doctorEntity.getFoto() );
        doctor.setMedicalRegister( doctorEntity.getRegistroMedico() );
        doctor.setEmail( doctorEntity.getCorreo() );
        doctor.setCellNumber( doctorEntity.getCelular() );
        doctor.setPhoneNumber( doctorEntity.getTelefono() );

        return doctor;
    }

    @Override
    public List<Doctor> toDoctorList(List<DoctorEntity> doctorEntityList) {
        if ( doctorEntityList == null ) {
            return null;
        }

        List<Doctor> list = new ArrayList<Doctor>( doctorEntityList.size() );
        for ( DoctorEntity doctorEntity : doctorEntityList ) {
            list.add( toDoctor( doctorEntity ) );
        }

        return list;
    }

    @Override
    public DoctorEntity toDoctorEntity(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setIdDoctor( doctor.getDoctorId() );
        doctorEntity.setNombre( doctor.getFirstName() );
        doctorEntity.setApellido( doctor.getLastName() );
        doctorEntity.setFechaNacimiento( doctor.getBirthDate() );
        doctorEntity.setEspecialidad( doctor.getSpeciality() );
        doctorEntity.setDireccion( doctor.getAddress() );
        doctorEntity.setFoto( doctor.getPhoto() );
        doctorEntity.setRegistroMedico( doctor.getMedicalRegister() );
        doctorEntity.setCorreo( doctor.getEmail() );
        doctorEntity.setCelular( doctor.getCellNumber() );
        doctorEntity.setTelefono( doctor.getPhoneNumber() );

        return doctorEntity;
    }
}
