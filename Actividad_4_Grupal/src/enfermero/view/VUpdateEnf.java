package enfermero.view;

import java.util.List;
import java.util.Scanner;

import common.model.IGestorCrud;
import doctor.model.Doctor;
import enfermero.model.Enfermero;

public class VUpdateEnf {

	
	private Scanner sc;
	private IGestorCrud gcEnf;
	private IGestorCrud gcDoc;

	/**
	 * @param gc
	 */
	public VUpdateEnf(IGestorCrud gcDoc, IGestorCrud gcEnf) {
		this.sc = new Scanner(System.in);
		this.gcEnf = gcEnf;
		this.gcDoc = gcDoc;
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
			System.out.println("ID");
			String id=sc.next();
			System.out.println("Disponible?");
			boolean disponible=sc.nextBoolean();
			System.out.println("Que doctor? Eliga de 0-posición disponible");
			List<Doctor> doctores = gcDoc.read();
			System.out.println(doctores);
			int pos1 = sc.nextInt();
			Enfermero e = new Enfermero(nombre, dNI, edad, id, disponible);
			doctores.get(pos1).addEnfermero(e);
			bRet=gcEnf.update(pos,e);
		} catch (Exception e) {
			System.out.println("Error en update");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
		return bRet;
	}
}
