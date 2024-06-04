package paciente.model;

import java.io.Serializable;
import java.util.Date;

public class Cita implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date cita;
	private String sala;
	/**
	 * @param cita
	 * @param sala
	 */
	public Cita(Date cita, String sala) {
		this.cita = cita;
		this.sala = sala;
		
	}

	/**
	 * @return the cita
	 */
	public Date getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(Date cita) {
		this.cita = cita;
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

	@Override
	public String toString() {
		return "[cita=" + cita + ", sala=" + sala + "]";
	}

}