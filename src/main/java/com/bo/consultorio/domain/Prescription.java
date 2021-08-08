package com.bo.consultorio.domain;

public class Prescription {
    private Integer prescriptionId;
    private String description;
    private Integer consultationId;
    private MedicalConsultation consultation;


    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MedicalConsultation getConsultation() {
        return consultation;
    }

    public void setConsultation(MedicalConsultation consultation) {
        this.consultation = consultation;
    }
}
