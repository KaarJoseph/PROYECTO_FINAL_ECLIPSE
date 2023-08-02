package ups.edu.ec.proyecto.Modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Persona implements Serializable {

    @Id
    private String cedula;
    private String nombre;
    private String direccion;
    
    @OneToMany(mappedBy = "propietario")
    private List<Vehiculo> vehiculos;
    
    @OneToMany(mappedBy = "propietarioCabecera")
    private List<Cabecera> cabeceras;
    
    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Cabecera> getCabeceras() {
        return cabeceras;
    }

    public void setCabeceras(List<Cabecera> cabeceras) {
        this.cabeceras = cabeceras;
    }

    @Override
    public String toString() {
        return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + "]";
    }
}
