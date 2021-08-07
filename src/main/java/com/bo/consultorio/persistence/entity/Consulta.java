package com.bo.consultorio.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsulta;
    private Date fecha;
    private Date fechaCreacion;
    private String creadoPor;
    private Date fechaActualizacion;
    private String actualizacionPor;
//    @ManyToOne
//    @JoinColumn(name = "idDoctor", insertable = false, updatable = false)
//    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "idPaciente", insertable = false, updatable = false)
    private Paciente paciente;
//    @OneToMany(mappedBy = "receta")
//    private ArrayList<Receta> recetaList = new ArrayList<>();

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
//
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getActualizacionPor() {
        return actualizacionPor;
    }

    public void setActualizacionPor(String actualizacionPor) {
        this.actualizacionPor = actualizacionPor;
    }

//    public ArrayList<Receta> getRecetaList() {
//        return recetaList;
//    }
//
//    public void setRecetaList(ArrayList<Receta> recetaList) {
//        this.recetaList = recetaList;
//    }
}
