package enfermedad.model;

import java.util.List;

import medicamento.model.Medicamento;


public class EnfermedadGrave extends Enfermedad {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sala;
	private int camilla;
	private int diasCamilla;
	/**
	 * @param nombre
	 * @param sintomas
	 * @param med
	 * @param sala
	 * @param camilla
	 * @param diasCamilla
	 */
	public EnfermedadGrave(String nombre, String sintomas, List<Medicamento> med, String sala, int camilla,
			int diasCamilla) {
		super(nombre, sintomas, med);
		this.sala = sala;
		this.camilla = camilla;
		this.diasCamilla = diasCamilla;
	}
	/**
	 * @return the sala
	 */
	public String getSala() {
		return sala;
	}
	/**
	 * @param sala the sala to set
	 */
	public void setSala(String sala) {
		this.sala = sala;
	}
	/**
	 * @return the camilla
	 */
	public int getCamilla() {
		return camilla;
	}
	/**
	 * @param camilla the camilla to set
	 */
	public void setCamilla(int camilla) {
		this.camilla = camilla;
	}
	/**
	 * @return the diasCamilla
	 */
	public int getDiasCamilla() {
		return diasCamilla;
	}
	/**
	 * @param diasCamilla the diasCamilla to set
	 */
	public void setDiasCamilla(int diasCamilla) {
		this.diasCamilla = diasCamilla;
	}
	@Override
	public String toString() {
		return "EnfermedadGrave [nombre=" + nombre + ", sintomas=" + sintomas + ", med=" + med + ", sala=" + sala + ", camilla=" + camilla + ", diasCamilla=" + diasCamilla + "]";
	}
	
}