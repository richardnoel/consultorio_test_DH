package com.bo.consultorio.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "creado_por")
    private String creadoPor;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    @Column(name = "actualizado_por")
    private String actualizacionPor;

    @ManyToOne()
    @JoinColumn(name = "id_doctor", insertable = false, updatable = false)
    private Doctor doctor;

    @ManyToOne()
    @JoinColumn(name = "id_paciente", insertable = false, updatable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receta> recetaList;


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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

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
