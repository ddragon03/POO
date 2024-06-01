package enfermedad.model;

import java.util.List;

import medicamento.model.Medicamento;


public class EnfermedadLeve extends Enfermedad {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int diasReposo;
	private String justificante;
	/**
	 * @param nombre
	 * @param sintomas
	 * @param med
	 * @param diasReposo
	 * @param justificante
	 */
	public EnfermedadLeve(String nombre, String sintomas, List<Medicamento> med, int diasReposo, String justificante) {
		super(nombre, sintomas, med);
		this.diasReposo = diasReposo;
		this.justificante = justificante;
	}
	/**
	 * @return the diasReposo
	 */
	public int getDiasReposo() {
		return diasReposo;
	}
	/**
	 * @param diasReposo the diasReposo to set
	 */
	public void setDiasReposo(int diasReposo) {
		this.diasReposo = diasReposo;
	}
	/**
	 * @return the justificante
	 */
	public String getJustificante() {
		return justificante;
	}
	/**
	 * @param justificante the justificante to set
	 */
	public void setJustificante(String justificante) {
		this.justificante = justificante;
	}
	@Override
	public String toString() {
		return "EnfermedadLeve [nombre=" + nombre + ", sintomas=" + sintomas + ", med=" + med + ", diasReposo=" + diasReposo + ", justificante=" + justificante + "]";
	}
	
	
	
}