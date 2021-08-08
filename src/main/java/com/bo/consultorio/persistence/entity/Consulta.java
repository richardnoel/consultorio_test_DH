package com.bo.consultorio.persistence.entity;

import javax.persistence.*;
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

    @Column(name = "id_doctor")
    private Integer idDoctor;

    @Column(name = "id_paciente")
    private Integer idPaciente;

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
    private DoctorEntity doctor;

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

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
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

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }
}
