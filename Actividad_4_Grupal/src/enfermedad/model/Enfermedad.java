package enfermedad.model;

import java.io.Serializable;
import java.util.List;

import medicamento.model.Medicamento;


public class Enfermedad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String sintomas;
	protected List<Medicamento> med;
	/**
	 * @param nombre
	 * @param sintomas
	 * @param med
	 */
	public Enfermedad(String nombre, String sintomas, List<Medicamento> med) {
		this.nombre = nombre;
		this.sintomas = sintomas;
		this.med = med;
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
	 * @return the sintomas
	 */
	public String getSintomas() {
		return sintomas;
	}
	/**
	 * @param sintomas the sintomas to set
	 */
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	/**
	 * @return the med
	 */
	public List<Medicamento> getMed() {
		return med;
	}
	/**
	 * @param med the med to set
	 */
	public void setMed(List<Medicamento> med) {
		this.med = med;
	}
	@Override
	public String toString() {
		return "Enfermedad [nombre=" + nombre + ", sintomas=" + sintomas + ", med=" + med + "]";
	}
	

}