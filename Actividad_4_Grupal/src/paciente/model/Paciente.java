package paciente.model;

import java.util.List;

public class Paciente {
	protected String nombre;
	private int edad;
	protected String genero;
	protected String dni;
	/**
	 * @param nombre
	 * @param edad
	 * @param genero
	 * @param dni
	 * @param listPaciente
	 */
	public Paciente(String nombre, int edad, String genero, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + ", dni=" + dni+ "]";
	}

}
