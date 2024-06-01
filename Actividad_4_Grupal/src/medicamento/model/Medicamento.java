package medicamento.model;
import java.io.Serializable;
import java.util.List;

import enfermedad.model.Enfermedad;

public class Medicamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String numSerie;
	private List<Enfermedad> enferm;
	private int cantidad;

	/**
	 * @param nombre
	 * @param numSerie
	 * @param enferm
	 * @param cantidad
	 */
	public Medicamento(String nombre, String numSerie, List<Enfermedad> enferm, int cantidad) {
		this.nombre = nombre;
		this.numSerie = numSerie;
		this.enferm = enferm;
		this.cantidad = cantidad;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * @param numSerie the numSerie to set
	 */
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * @return the enferm
	 */
	public List<Enfermedad> getEnferm() {
		return enferm;
	}

	/**
	 * @param enferm the enferm to set
	 */
	public void setEnferm(List<Enfermedad> enferm) {
		this.enferm = enferm;
	}

	/**
	 * @return the disponibilidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Medicamento [nombre=" + nombre + ", numSerie=" + numSerie + ", enferm=" + enferm + ", cantidad="
				+ cantidad + "]";
	}


	/**
	 * @param enfermedades the enfermedades to set
	 */
	public void setEnfermedades(List<Enfermedad> enfermedades) {
		this.enferm = enfermedades;
	}

}