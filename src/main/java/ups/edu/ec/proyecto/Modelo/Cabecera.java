package ups.edu.ec.proyecto.Modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Cabecera{

    @Id
    private int ticketInt;
    private String numTicket;
    private Timestamp fechaEmision;
    private double costoTotal;
    private String estado;
    
    @ManyToOne
    private Persona propietarioCabecera;
    
    /*
    @OneToMany(mappedBy = "cabecera", cascade = CascadeType.PERSIST)
    private List<Detalle> detalles;
*/

    public int getTicketInt() {
        return ticketInt;
    }

    public void setTicketInt(int ticketInt) {
        this.ticketInt = ticketInt;
    }

    public String getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(String numTicket) {
        this.numTicket = numTicket;
    }

    public Timestamp getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Timestamp fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPropietarioCabecera() {
        return propietarioCabecera;
    }

    public void setPropietarioCabecera(Persona propietarioCabecera) {
        this.propietarioCabecera = propietarioCabecera;
    }

    /*public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(Detalle detalle) {
        if (detalles == null) {
            detalles = new ArrayList<>();
        }
        detalles.add(detalle);
        detalle.setCabecera(this); // Establecer la relación bidireccional
    }*/



    @Override
    public String toString() {
        return "Cabecera [ticketInt=" + ticketInt + ", numTicket=" + numTicket + ", fechaEmision=" + fechaEmision
                + ", costoTotal=" + costoTotal + ", estado=" + estado + "]";
    }
}
