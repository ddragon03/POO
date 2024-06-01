package doctor.view;

import java.util.ArrayList;
import java.util.Scanner;

import common.model.IGestorCrud;
import paciente.model.Paciente;
import doctor.model.Doctor;
import enfermero.model.Enfermero;


public class VCreateDoc {
	private Scanner sc;
	private IGestorCrud gc;

	/**
	 * @param gc
	 */
	public VCreateDoc(IGestorCrud gc) {
		this.sc = new Scanner(System.in);
		this.gc = gc;
	}

	public void menu() {
		try {
			System.out.println("Nombre");
			String nombre=sc.next();
			System.out.println("DNI");
			String dNI= sc.next();
			System.out.println("Edad");
			int edad = sc.nextInt();
			System.out.println("Especialidad");
			String especialidad=sc.next();
			System.out.println("ID");
			String id=sc.next();
			System.out.println("Jornada");
			String jornada=sc.next();
			gc.create(new Doctor(nombre, dNI, edad, especialidad, id, jornada, new ArrayList<Paciente>(), new ArrayList<Enfermero>()));
		} catch (Exception e) {
			System.out.println("Error en create");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
	}
}

