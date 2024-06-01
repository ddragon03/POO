package common.persona;


import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	public String nombre;
	public String DNI;
	public int edad;
	/**
	 * @param nombre
	 * @param dNI
	 * @param edad
	 */
	public Persona(String nombre, String dNI, int edad) {
		this.nombre = nombre;
		DNI = dNI;
		this.edad = edad;
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
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}
	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", DNI=" + DNI + ", edad=" + edad + "]";
	}

}
