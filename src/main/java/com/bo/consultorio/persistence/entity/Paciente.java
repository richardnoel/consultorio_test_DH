package com.bo.consultorio.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "numero_documento")
    private Integer numeroDocuemnto;

    private String nombre;

    private String apellido;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String direccion;

    private String foto;

    private String correo;

    private String celular;

    private String telefono;

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


    //@OneToMany(mappedBy = "paciente")
    //private List<Historial> historialList;
    @OneToOne(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Historial historial;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultaList;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getNumeroDocuemnto() {
        return numeroDocuemnto;
    }

    public void setNumeroDocuemnto(Integer numeroDocuemnto) {
        this.numeroDocuemnto = numeroDocuemnto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
//
//    public List<Historial> getHistorialList() {
//        return historialList;
//    }
//
//    public void setHistorialList(List<Historial> historialList) {
//        this.historialList = historialList;
//    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
}
