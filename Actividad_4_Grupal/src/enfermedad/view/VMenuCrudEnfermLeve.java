package enfermedad.view;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import enfermedad.model.GestorCrudEnfermLeve;
import medicamento.model.Medicamento;
import enfermedad.model.EnfermedadLeve;


public class VMenuCrudEnfermLeve implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestorCrudEnfermLeve gc;
	private Scanner sc;
	/**
	 * @param Medicamentos array de Medicamentos
	 * @param sc scanner
	 * @param size numero real de elementos
	 */
	public VMenuCrudEnfermLeve(GestorCrudEnfermLeve enfermLeve) {
		this.gc = enfermLeve;
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
			System.out.println("sintomas");
			String sintomas=sc.next();
			System.out.println("dias de reposo");
			int diasReposo=sc.nextInt();
			System.out.println("justificante");
			String justificante=sc.next();
			gc.create(new EnfermedadLeve(nombre,sintomas, new ArrayList<Medicamento>(),diasReposo,justificante));
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
			System.out.println("nombre");
			String nombre=sc.next();
			System.out.println("sintomas");
			String sintomas=sc.next();
			System.out.println("dias de reposo");
			int diasReposo=sc.nextInt();
			System.out.println("justificante");
			String justificante=sc.next();
			bRet= gc.update(pos, new EnfermedadLeve(nombre,sintomas,new ArrayList<Medicamento>(),diasReposo,justificante));

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

