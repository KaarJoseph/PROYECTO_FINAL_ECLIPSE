package ups.edu.ec.proyecto.Modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import ups.edu.ec.proyecto.Modelo.Cabecera;

@Entity
public class Vehiculo implements Serializable{

	@Id
	//@GeneratedValue
    private Integer vehiculoId;
    private String placa;
    private String marca;
    private String modelo;
    private String tipo;
    
    //@OneToOne
    //@JoinColumn(name = "persona_cedula")
    //private Persona persona;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Cabecera> cabeceras;
    
    public Integer getVehiculoId() {
        return vehiculoId;
    }
    
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
    
    public String getPlaca() {
        return placa; 
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /*public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    */
    public List<Cabecera> getCabeceras() {
        return cabeceras;
    }
    
    public void setCabeceras(List<Cabecera> cabeceras) {
        this.cabeceras = cabeceras;
    }

	@Override
	public String toString() {
		return "Vehiculo [vehiculoId=" + vehiculoId + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo
				+ ", tipo=" + tipo + ", cabeceras=" + cabeceras + "]";
	}
    
 	
}
