package com.bo.consultorio.persistence.mapper;

import com.bo.consultorio.domain.MedicalHistory;
import com.bo.consultorio.persistence.entity.Historial;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-07T16:56:29-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Eclipse Foundation)"
)
@Component
public class MedicalHistoryMapperImpl implements MedicalHistoryMapper {

    @Override
    public MedicalHistory toMedicalHistory(Historial historial) {
        if ( historial == null ) {
            return null;
        }

        MedicalHistory medicalHistory = new MedicalHistory();

        medicalHistory.setIdHistory( historial.getIdHistorial() );
        medicalHistory.setHistory( historial.getHistoral() );

        return medicalHistory;
    }

    @Override
    public List<MedicalHistory> toMedicalHistorys(List<Historial> historialList) {
        if ( historialList == null ) {
            return null;
        }

        List<MedicalHistory> list = new ArrayList<MedicalHistory>( historialList.size() );
        for ( Historial historial : historialList ) {
            list.add( toMedicalHistory( historial ) );
        }

        return list;
    }

    @Override
    public Historial toHistorial(MedicalHistory medicalHistory) {
        if ( medicalHistory == null ) {
            return null;
        }

        Historial historial = new Historial();

        historial.setIdHistorial( medicalHistory.getIdHistory() );
        historial.setHistoral( medicalHistory.getHistory() );

        return historial;
    }
}
