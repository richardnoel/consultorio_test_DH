package com.bo.consultorio.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @Column(name = "id_paciente")
    private Integer idPaciente;

    private String historal;


//    @ManyToOne
//    @JoinColumn(name = "id_paciente", insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", insertable = false, updatable = false)
    private Paciente paciente;

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

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getHistoral() {
        return historal;
    }

    public void setHistoral(String historal) {
        this.historal = historal;
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

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
}
