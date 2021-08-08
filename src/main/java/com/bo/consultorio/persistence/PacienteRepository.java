package com.bo.consultorio.persistence;

import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.domain.repository.PatientRepository;
import com.bo.consultorio.persistence.crud.PacienteCrud;
import com.bo.consultorio.persistence.entity.Paciente;
import com.bo.consultorio.persistence.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class PacienteData implements PatientRepository {
    @Autowired
    private PacienteCrud pacienteCrud;
    @Autowired
    private PatientMapper mapper;

    @Override
    public Optional<Patient> getPatien(int patientId) {
        return pacienteCrud.findById(patientId).map(paciente -> mapper.toPatient(paciente));
    }

    @Override
    public List<Patient> getAll() {
        List<Paciente> pacienteList = (List<Paciente>) pacienteCrud.findAll();
        return mapper.toPatiens(pacienteList);
    }

    @Override
    public List<Patient> getByName(String name) {
        List<Paciente> pacienteList = pacienteCrud.findByNombreOrderByNombreAsc(name);
        return mapper.toPatiens(pacienteList);
    }

    @Override
    public Optional<List<Patient>> getByLastName(String lastName) {
        List<Paciente> pacienteList = pacienteCrud.findByApellidoOrderByApellidoAsc(lastName);
        return Optional.of(mapper.toPatiens(pacienteList));
    }

    @Override
    public Optional<List<Patient>> getByDocumentNumber(int documentNumber) {
        List<Paciente> pacienteList = pacienteCrud.findByNumeroDocuemnto(documentNumber);
        return Optional.of(mapper.toPatiens(pacienteList));
    }

    @Override
    public Patient save(Patient patient) {
        Paciente paciente = mapper.toPaciente(patient);
        paciente = pacienteCrud.save(paciente);
        return mapper.toPatient(paciente);
    }

    @Override
    public void delete(int patientId) {
        pacienteCrud.deleteById(patientId);
    }
}
