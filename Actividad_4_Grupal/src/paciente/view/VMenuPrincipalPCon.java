package paciente.view;

import java.util.ArrayList;
import java.util.List;

import common.model.IGestorCrud;
import paciente.model.GestorCrudPCon;
import paciente.model.Paciente;

public class VMenuPrincipalPCon {
	private IGestorCrud gc;
	
	/**
	 * @param gcPac
	 * @param gcDoc
	 */
	public VMenuPrincipalPCon(IGestorCrud gc) {
		this.gc = gc;
		
	}

	/**
	 * Muestra opciones CRUD al usuario
	 */
	public void menu() {
		//creamos la instancia para pedir los datos
		VMenuCrudPCon datos=new VMenuCrudPCon(gc);
		//bucle para pedir datos
		int opcion=datos.menu();
		while(opcion!=0) {
			if (opcion==1)
				
				datos.create();
			else if (opcion==2)
				datos.read();
			else if (opcion==3)
				datos.update();
			else if (opcion==4)
				datos.delete();
			opcion=datos.menu();
		}
	} 

}
