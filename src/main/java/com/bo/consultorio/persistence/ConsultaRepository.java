package com.bo.consultorio.persistence;

import com.bo.consultorio.domain.MedicalConsultation;
import com.bo.consultorio.domain.repository.MedicalConsultationRepository;
import com.bo.consultorio.persistence.crud.ConsultaCrud;
import com.bo.consultorio.persistence.entity.Consulta;
import com.bo.consultorio.persistence.mapper.MedicalConsultationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ConsultaRepository implements MedicalConsultationRepository {
    @Autowired
    private ConsultaCrud crud;
    @Autowired
    private MedicalConsultationMapper mapper;


    @Override
    public List<MedicalConsultation> getAll() {
        List<Consulta> consultaList = (List<Consulta>) crud.findAll();
        return mapper.toMedicalConsultationList(consultaList);
    }

    @Override
    public MedicalConsultation getMedicalConsultation(int consultationId) {
        MedicalConsultation consultation = new MedicalConsultation();
        try {
            Optional<Consulta> consultaOpt = crud.findById(consultationId);
            Optional<MedicalConsultation> doctorOpt = consultaOpt.map(item -> mapper.toMedicalConsultation(item));
            consultation = doctorOpt.get();
            return consultation;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<MedicalConsultation> getMedicalConsultationByDoctor(int doctorId) {
        List<MedicalConsultation> medicalConsultationList = new ArrayList<>();
        MedicalConsultation consultation = new MedicalConsultation();
        try {
            List<Consulta> consultaList = crud.findByIdDoctor(doctorId);
            consultaList.forEach(item -> {
                MedicalConsultation medicalConsultation = mapper.toMedicalConsultation(item);
                medicalConsultationList.add(medicalConsultation);
            });
            return medicalConsultationList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public MedicalConsultation save(MedicalConsultation consultation) {
        Consulta consulta = mapper.toConsulta(consultation);
        consulta = crud.save(consulta);
        return mapper.toMedicalConsultation(consulta);
    }

    @Override
    public void delete(int consultationId) {
        crud.deleteById(consultationId);
    }
}
