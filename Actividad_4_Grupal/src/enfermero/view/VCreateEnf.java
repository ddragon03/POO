package enfermero.view;

import java.util.List;
import java.util.Scanner;

import common.model.IGestorCrud;
import doctor.model.Doctor;
import enfermero.model.Enfermero;


public class VCreateEnf {
	private Scanner sc;
	private IGestorCrud gcEnf;
	private IGestorCrud gcDoc;

	/**
	 * @param gc
	 */
	public VCreateEnf(IGestorCrud gcDoc, IGestorCrud gcEnf) {
		this.sc = new Scanner(System.in);
		this.gcEnf = gcEnf;
		this.gcDoc = gcDoc;
	}

	public void menu() {
		try {
			System.out.println("Nombre");
			String nombre=sc.next();
			System.out.println("DNI");
			String dNI= sc.next();
			System.out.println("Edad");
			int edad = sc.nextInt();
			System.out.println("ID");
			String id=sc.next();
			System.out.println("Disponible?");
			boolean disponible=sc.nextBoolean();
			System.out.println("Que doctor? Eliga de 0-posición disponible");
			List<Doctor> doctores = gcDoc.read();
			System.out.println(doctores);
			int pos = sc.nextInt();
			Enfermero e = new Enfermero(nombre, dNI, edad, id, disponible);
			doctores.get(pos).addEnfermero(e);
			gcEnf.create(e);
		} catch (Exception e) {
			System.out.println("Error en create");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
	}
}
