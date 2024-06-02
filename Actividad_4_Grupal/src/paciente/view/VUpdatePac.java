package paciente.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import common.model.IGestorCRUD;
import doctor.model.Doctor;
import paciente.model.Cita;
import paciente.model.Paciente;
import paciente.model.PacienteCon;

public class VUpdatePac {
	
	private Scanner sc;
	private IGestorCRUD gcPac;
	private IGestorCRUD gcDoc;

	/**
	 * @param gc
	 */
	public VUpdatePac(IGestorCRUD gcDoc, IGestorCRUD gcPac) {
		this.sc = new Scanner(System.in);
		this.gcPac = gcPac;
		this.gcDoc = gcDoc;
	}
	
	public boolean menu() {
		boolean bRet=false;
		try{
			System.out.println("Introduce la pos");
			int pos=sc.nextInt();
			System.out.println("Nombre");
			String nombre=sc.next();
			System.out.println("Edad");
			int edad=sc.nextInt();
			System.out.println("Genero");
			String genero=sc.next();
			System.out.println("DNI");
			String dni=sc.next();
			System.out.println("Tienes cita?");
			String verificarCita = sc.next();
			Cita c = new Cita(null, "null");
			if(verificarCita.equals("si")) {
				System.out.println("Año");
				int year = sc.nextInt();
				System.out.println("Mes");
				int mes = sc.nextInt();
				System.out.println("Dia");
				int dia = sc.nextInt();
				System.out.println("Hora");
				int hora = sc.nextInt();
				System.out.println(":15, :30, :45?");
				int min= sc.nextInt();
				System.out.println("Que zona?");
				String sala=sc.next();
				@SuppressWarnings("deprecation")
				Date cita = new Date (year,mes,dia,hora,min);
				c = new Cita (cita,sala);
			}else if (verificarCita.equals("no")) {
				c = new Cita(null,"null");
			}
			System.out.println("Que doctor? Eliga de 0-posición disponible");
			List<Doctor> doctores = gcDoc.read();
			System.out.println(doctores);
			int pos1 = sc.nextInt();
			Paciente p = new PacienteCon(nombre, edad, genero, dni,c);
			doctores.get(pos1).addPaciente(p);
			bRet=gcPac.update(pos,p);
		} catch (Exception e) {
			System.out.println("Error en update");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
		return bRet;
	}
	
}
