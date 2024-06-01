package paciente.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import common.model.IGestorCrud;
import doctor.model.Doctor;
import enfermero.model.Enfermero;
import paciente.model.Cita;
import paciente.model.GestorCrudPCon;
import paciente.model.Paciente;
import paciente.model.PacienteCon;

public class VMenuCrudPCon implements Serializable{
	private static final long serialVersionUID = 1L;
	private IGestorCrud gc;
	private Scanner sc;
	
	/**
	 * @param gcPac
	 * @param sc
	 * @param gcDoc
	 */
	public VMenuCrudPCon(IGestorCrud gc) {
		this.gc = gc;
		this.sc = new Scanner(System.in);
	
	}
	/**
	 * muestra menu principal
	 * @return opcion seleccionada o -1 si da un error
	 */
	public int menu() {
		try {
			System.out.println("Introduce una opcion");
			System.out.println("1. Create (C)");
			System.out.println("2. Read (R)");
			System.out.println("3. Update (U)");
			System.out.println("4. Delete (D)");
			System.out.println("0. Volver");
			return sc.nextInt();
		} catch (Exception e) {
			System.out.println("Opcion erronea");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
			return -1;
		}
	}
	/**
	 * agrega elementos
	 */
	public void create() {
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
			}
			System.out.println("Que doctor? Eliga de 0-posición disponible");
			List<Doctor> doctores = gc.read();
			System.out.println(doctores);
			int pos = sc.nextInt();
			Paciente p = new PacienteCon(nombre, edad, genero, dni, c);
			doctores.get(pos).addPacientes(p);
			gc.create(p);
		} catch (Exception e) {
			System.out.println("Error en create");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
	}
	/**
	 * muestra por pantalla las Medicamentos
	 */
	public void read() {
		System.out.println(gc.read());
	}
	/**
	 * actualiza
	 * @return verdadero si actualiza
	 */
	public boolean update() {
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
			}
			System.out.println("Que doctor? Eliga de 0-posición disponible");
			List<Doctor> doctores = gc.read();
			System.out.println(doctores);
			int pos1 = sc.nextInt();
			Paciente p = new PacienteCon(nombre, edad, genero, dni,c);
			doctores.get(pos).addPacientes(p);
			bRet=gc.update(pos1,p);
		} catch (Exception e) {
			System.out.println("Error en update");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
		return bRet;
	}
	/**
	 * borra
	 * @return verdadero si borra
	 */
	public boolean delete() {
		boolean bRet=false;
		try {
			System.out.println("Introduce la pos");
			int pos=sc.nextInt();
			bRet=gc.delete(pos);

		} catch (Exception e) {
			System.out.println("Error en delete");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
		return bRet;
	}

}
