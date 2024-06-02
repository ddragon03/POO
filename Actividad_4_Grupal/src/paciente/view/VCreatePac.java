package paciente.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import common.model.IGestorCRUD;
import doctor.model.Doctor;
import paciente.model.Cita;
import paciente.model.PacienteCon;

public class VCreatePac {
	private Scanner sc;
	private IGestorCRUD gcPac;
	private IGestorCRUD gcDoc;

	/**
	 * @param gc
	 */
	public VCreatePac(IGestorCRUD gcDoc, IGestorCRUD gcPac) {
		this.sc = new Scanner(System.in);
		this.gcPac = gcPac;
		this.gcDoc = gcDoc;
	}
	
	public void menu() {

		try {
			System.out.println("nombre");
			String nombre=sc.next();
			System.out.println("edad");
			int edad=sc.nextInt();
			System.out.println("genero");
			String genero=sc.next();
			System.out.println("dni");
			String dni=sc.next();
			System.out.println("Tienes cita?");
			String verificarCita = sc.next();
			Cita c = new Cita(null, "null");
			if(verificarCita.equals("si")) { //verifica si el paciente tiene cita, y crea la cita si si la tiene
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
			int pos = sc.nextInt();
			PacienteCon p = new PacienteCon(nombre, edad, genero, dni, c);
			doctores.get(pos).addPaciente(p);
			gcPac.create(p);
		} catch (Exception e) {
			System.out.println("Error en create");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
	}

}
