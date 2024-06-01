package paciente.model;

import paciente.model.Cita;
import java.util.List;

public class PacienteCon extends Paciente {
 
	private Cita cita;

	/**
	 * @param nombre
	 * @param edad
	 * @param genero
	 * @param dni
	 * @param c
	 */
	public PacienteCon(String nombre, int edad, String genero, String dni, Cita c) {
		super(nombre, edad, genero, dni);
		this.cita = c;
	}

	/**
	 * @return the citas
	 */
	public Cita getCitas() {
		return cita;
	}

	/**
	 * @param citas the citas to set
	 */
	
	public void setCitas(Cita citas) {
		this.cita = citas;
	}

	@Override
	public String toString() {
		return "[citas=" + cita + "]";
	}

	
	

}
