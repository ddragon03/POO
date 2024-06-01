package enfermero.model;

import personal.Personal;

public class Enfermero extends Personal {
	private static final long serialVersionUID = 1L;
	private boolean disponiblidad;

	/**
	 * @param nombre
	 * @param dNI
	 * @param edad
	 * @param id
	 * @param disponiblidad
	 */
	public Enfermero(String nombre, String dNI, int edad, String id, boolean disponiblidad) {
		super(nombre, dNI, edad, id);
		this.disponiblidad = disponiblidad;
	}

	@Override
	public String toString() {
		return "Enfermero [disponiblidad=" + disponiblidad + ", id=" + id + ", nombre=" + nombre + ", DNI=" + DNI
				+ ", edad=" + edad + "]";
	}

	/**
	 * @return the disponiblidad
	 */
	public boolean isDisponiblidad() {
		return disponiblidad;
	}

	/**
	 * @param disponiblidad the disponiblidad to set
	 */
	public void setDisponiblidad(boolean disponiblidad) {
		this.disponiblidad = disponiblidad;
	}
	

}
