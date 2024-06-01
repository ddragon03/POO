package medicamento.view;
import java.util.ArrayList;
import java.util.Scanner;

import enfermedad.model.Enfermedad;
import common.model.IGestorCrud;
import medicamento.model.Medicamento;

public class VMenuCrudMed {
	private IGestorCrud gc;
	private Scanner sc;
	/**
	 * @param Medicamentos array de Medicamentos
	 * @param sc scanner
	 * @param size numero real de elementos
	 */
	public VMenuCrudMed(IGestorCrud meds) {
		this.gc = meds;
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
			System.out.println("num serie");
			String numSerie=sc.next();
			System.out.println("cantidad");
			int cantidad=sc.nextInt();
			gc.create(new Medicamento(nombre,numSerie, new ArrayList<Enfermedad>(), cantidad ));
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
			System.out.println("num serie");
			String numSerie=sc.next();
			System.out.println("cantidad");
			int cantidad=sc.nextInt();
			bRet= gc.update(pos, new Medicamento(nombre,numSerie, new ArrayList<Enfermedad>(), cantidad));

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

