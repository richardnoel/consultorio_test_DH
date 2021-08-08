package com.bo.consultorio.persistence;

import com.bo.consultorio.domain.MedicalHistory;
import com.bo.consultorio.domain.Patient;
import com.bo.consultorio.domain.repository.MedicalHistoryRepository;
import com.bo.consultorio.domain.repository.PatientRepository;
import com.bo.consultorio.domain.service.PatientService;
import com.bo.consultorio.persistence.crud.HistorialCrud;
import com.bo.consultorio.persistence.entity.Historial;
import com.bo.consultorio.persistence.mapper.MedicalHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HistorialData implements MedicalHistoryRepository {
    @Autowired
    private HistorialCrud historialCrud;
    @Autowired
    private MedicalHistoryMapper mapper;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Optional<MedicalHistory> getHistory(int idHistory) {
        return historialCrud.findById(idHistory).map(historial -> mapper.toMedicalHistory(historial));
    }

    @Override
    public List<MedicalHistory> getAll() {
        List<Historial> historialList = (List<Historial>) historialCrud.findAll();
        return mapper.toMedicalHistorys(historialList);
    }

    @Override
    public Optional<List<MedicalHistory>> getByPatient(int idPaciente) {
        List<Historial> historialList = historialCrud.findByIdPaciente(idPaciente);
        try {
            Optional<Patient> patientOpt = patientService.getPatiente(idPaciente);
            Patient patient = patientOpt.get();
            List<MedicalHistory> medicalHistoryList = mapper.toMedicalHistorys(historialList);
            medicalHistoryList.forEach(medicalHistory -> {
                medicalHistory.setPatient(patient);
            });
            return Optional.of(medicalHistoryList);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public MedicalHistory save(MedicalHistory medicalHistory) {
        Historial historial = mapper.toHistorial(medicalHistory);
        historial = historialCrud.save(historial);
        return mapper.toMedicalHistory(historial);
    }

    @Override
    public void delete(Integer idHistory) {
        historialCrud.deleteById(idHistory);
    }
}
