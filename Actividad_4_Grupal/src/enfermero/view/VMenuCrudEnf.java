package enfermero.view;

import common.model.IGestorCrud;
import enfermero.model.GestorEnf;

import java.util.Scanner;

public class VMenuCrudEnf {
	IGestorCrud gestorEnf;
	IGestorCrud gestorDoc;
	private Scanner sc;
	
	public VMenuCrudEnf(IGestorCrud gestorDoc, IGestorCrud gestorEnf) {
		this.gestorDoc=gestorDoc;
		this.gestorEnf=gestorEnf;
		this.sc = new Scanner(System.in);
	}
	/**
	 * Muestra opciones CRUD al usuario
	 */
	public void menu() {
		//bucle para pedir datos
		int opcion=menuOpcion();
		while(opcion!=0) {
			if (opcion==1) {
				//creamos la instancia para crear
				VCreateEnf vCreate=new VCreateEnf(gestorDoc,gestorEnf);
				vCreate.menu();
			}else if (opcion==2) {
				//creamos la instancia para leer
				VReadEnf vRead=new VReadEnf(gestorEnf);
				vRead.menu();
			}else if (opcion==3) {
				//creamos la instancia para actualizar
				VUpdateEnf vUpdate=new VUpdateEnf(gestorDoc, gestorEnf);
				boolean bRes=vUpdate.menu();
				if(bRes)
					System.out.println("Actualizado correctamente");
				else
					System.out.println("No se ha actualizado correctamente");
			}else if (opcion==4) {
				//creamos la instancia para borrar
				VDeleteEnf vDelete=new VDeleteEnf(gestorEnf);
				boolean bRes=vDelete.menu();
				if(bRes)
					System.out.println("Borrado correctamente");
				else
					System.out.println("No se ha borrado correctamente");
			}
			opcion=menuOpcion();
		}
	} 
	/**
	 * muestra menu CRUD
	 * @return opcion seleccionada o -1 si da un error
	 */
	public int menuOpcion() {
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
}