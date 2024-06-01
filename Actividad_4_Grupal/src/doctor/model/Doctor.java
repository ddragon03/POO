package doctor.model;

import java.util.ArrayList;
import java.util.List;

import common.persona.Persona;
import enfermero.model.Enfermero;
import paciente.model.Paciente;
import personal.Personal;

public class Doctor extends Personal{
	private static final long serialVersionUID = 1L;
	private String especialidad;
	private String jornada;
	private List <Paciente> pacientes;
	private List <Enfermero> enfermeros;

	/**
	 * @param nombre
	 * @param dNI
	 * @param edad
	 * @param id
	 * @param especialidad
	 * @param jornada
	 * @param arrayList
	 * @param enfermero
	 */

	public Doctor(String nombre, String dNI, int edad, String id, String especialidad, String jornada,
			List<Paciente> arrayList, List<Enfermero> enfermero) {
		super(nombre, dNI, edad, id);
		this.especialidad = especialidad;
		this.jornada = jornada;
		this.pacientes = arrayList;
		this.enfermeros = enfermero;
	}


	@Override
	public String toString() {
		return "Doctor [nombre=" + nombre + ", DNI=" + DNI + ", edad=" + edad
				+ ", ID=" + id + ", especialidad=" + especialidad + ", enfermeros" + enfermeros + ", pacientes=" + pacientes + ", jornada=" + jornada
				+ "]";
	}


	/**
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}


	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	/**
	 * @return the jornada
	 */
	public String getJornada() {
		return jornada;
	}


	/**
	 * @param jornada the jornada to set
	 */
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	/**
	 * @return the enfermero
	 */
	public List<Paciente> getPaciente() {
		return pacientes;
	}
	/**
	 * @return the pacientes
	 */
	public void addPacientes(Paciente paciente) {
		pacientes.add(paciente);
	}

	/**
	 * @return the enfermero
	 */
	public List<Enfermero> getEnfermero() {
		return enfermeros;
	}

	/**
	 * @param enfermero the enfermero to set
	 */
	public void addEnfermero(Enfermero enfermero) {
		enfermeros.add(enfermero);
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
