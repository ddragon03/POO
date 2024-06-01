package doctor.view;

import java.util.ArrayList;
import java.util.Scanner;

import common.model.IGestorCrud;
import paciente.model.Paciente;
import doctor.model.Doctor;
import enfermero.model.Enfermero;

public class VUpdateDoc {

	
	private Scanner sc;
	private IGestorCrud gc;

	/**
	 * @param sc
	 * @param gc
	 */
	public VUpdateDoc(IGestorCrud gc) {
		this.sc = new Scanner(System.in);
		this.gc = gc;
	}
	
	public boolean menu() {
		boolean bRet=false;
		try{
			System.out.println("Introduce la pos");
			int pos=sc.nextInt();
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
			bRet=gc.update(pos,new Doctor(nombre, dNI, edad, especialidad, id, jornada, new ArrayList<Paciente>(), new ArrayList<Enfermero>()));
		} catch (Exception e) {
			System.out.println("Error en update");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
		return bRet;
	}
}
