package enfermedad.view;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import enfermedad.model.GestorCrudEnfermGrave;
import medicamento.model.Medicamento;
import enfermedad.model.EnfermedadGrave;


public class VMenuCrudEnfermGrave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestorCrudEnfermGrave gc;
	private Scanner sc;
	/**
	 * @param Medicamentos array de Medicamentos
	 * @param sc scanner
	 * @param size numero real de elementos
	 */
	public VMenuCrudEnfermGrave(GestorCrudEnfermGrave enfermGrave) {
		this.gc = enfermGrave;
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
			System.out.println("sala");
			String sala=sc.next();
			System.out.println("camilla");
			int camilla=sc.nextInt();
			System.out.println("dias en camilla");
			int diasCamilla=sc.nextInt();
			gc.create(new EnfermedadGrave(nombre,sintomas, new ArrayList<Medicamento>(),sala,camilla,diasCamilla));
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
			System.out.println("sala");
			String sala=sc.next();
			System.out.println("camilla");
			int camilla=sc.nextInt();
			System.out.println("dias en camilla");
			int diasCamilla=sc.nextInt();
			bRet= gc.update(pos, new EnfermedadGrave(nombre,sintomas,new ArrayList<Medicamento>(),sala,camilla,diasCamilla));

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

