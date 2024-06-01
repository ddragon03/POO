package personal;


import common.persona.Persona;

public class Personal extends Persona{
	private static final long serialVersionUID = 1L;
	public String id;

	/**
	 * @param nombre
	 * @param dNI
	 * @param edad
	 * @param id
	 */
	public Personal(String nombre, String dNI, int edad, String id) {
		super(nombre, dNI, edad);
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + "]";
	}


}
