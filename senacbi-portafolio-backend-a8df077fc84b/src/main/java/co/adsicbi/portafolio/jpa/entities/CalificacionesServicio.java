/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.adsicbi.portafolio.jpa.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "CALIFICACIONES_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalificacionesServicio.findAll", query = "SELECT c FROM CalificacionesServicio c"),
    @NamedQuery(name = "CalificacionesServicio.findByIdCalificacion", query = "SELECT c FROM CalificacionesServicio c WHERE c.idCalificacion = :idCalificacion"),
    @NamedQuery(name = "CalificacionesServicio.findByPuntuacion", query = "SELECT c FROM CalificacionesServicio c WHERE c.puntuacion = :puntuacion"),
    @NamedQuery(name = "CalificacionesServicio.findByComentario", query = "SELECT c FROM CalificacionesServicio c WHERE c.comentario = :comentario"),
    @NamedQuery(name = "CalificacionesServicio.findByFecha", query = "SELECT c FROM CalificacionesServicio c WHERE c.fecha = :fecha")})
public class CalificacionesServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificacion")
    private Integer idCalificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntuacion")
    private short puntuacion;
    @Size(max = 140)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicios idServicio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    @Transient
    SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");

    public CalificacionesServicio() {
    }

    public CalificacionesServicio(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public CalificacionesServicio(Integer idCalificacion, short puntuacion, Date fecha) {
        this.idCalificacion = idCalificacion;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public short getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(short puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return date.format(fecha);
    }

    public void setFecha(String fecha) {
        try {
            this.fecha = date.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(CalificacionesServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacion != null ? idCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionesServicio)) {
            return false;
        }
        CalificacionesServicio other = (CalificacionesServicio) object;
        if ((this.idCalificacion == null && other.idCalificacion != null) || (this.idCalificacion != null && !this.idCalificacion.equals(other.idCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.adsicbi.portafolio.jpa.entities.CalificacionesServicio[ idCalificacion=" + idCalificacion + " ]";
    }

}
