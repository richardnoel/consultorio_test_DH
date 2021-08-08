package com.bo.consultorio.persistence;

import com.bo.consultorio.domain.Prescription;
import com.bo.consultorio.domain.Prescription;
import com.bo.consultorio.domain.repository.PrescriptionRepository;
import com.bo.consultorio.persistence.crud.RecetaCrud;
import com.bo.consultorio.persistence.entity.Consulta;
import com.bo.consultorio.persistence.entity.Receta;
import com.bo.consultorio.persistence.mapper.PrescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RecetaRepository implements PrescriptionRepository {
    @Autowired
    private RecetaCrud crud;
    @Autowired
    private PrescriptionMapper mapper;


    @Override
    public List<Prescription>  getAll() {
        List<Receta> recetaList = (List<Receta>) crud.findAll();
        return mapper.toPrescriptionList(recetaList);
    }

    @Override
    public Prescription getPrescription(int prescriptionId) {
        Prescription prescription = new Prescription();
        try {
            Optional<Receta> recetaOpt = crud.findById(prescriptionId);
            Optional<Prescription> doctorOpt = recetaOpt.map(item -> mapper.toPrescription(item));
            prescription = doctorOpt.get();
            return prescription;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    @Override
    public List<Prescription> getPrescriptionByConsultation(int consultationId) {
        List<Prescription> prescriptionList = new ArrayList<>();
        Prescription consultation = new Prescription();
        try {
            List<Receta> consultaList = crud.findByIdConsulta(consultationId);
            consultaList.forEach(item -> {
                Prescription prescription = mapper.toPrescription(item);
                prescriptionList.add(prescription);
            });
            return prescriptionList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    @Override
    public Prescription save(Prescription prescription) {
        System.out.println(":::::1::::");
        Receta receta = mapper.toReceta(prescription);
        System.out.println(":::::2::::");
        receta = crud.save(receta);
        System.out.println(":::::3::::");
        return mapper.toPrescription(receta);
    }
    @Override
    public void delete(int prescriptionId) {
        crud.deleteById(prescriptionId);
    }
}
