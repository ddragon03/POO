package paciente.view;

import java.util.ArrayList;
import java.util.List;

import paciente.model.GestorCrudPSin;
import paciente.model.Paciente;

public class VMenuPrincipalPSin {
	GestorCrudPSin gestor;
	public VMenuPrincipalPSin(GestorCrudPSin gestor) {
		this.gestor=gestor;
	}

	/**
	 * Muestra opciones CRUD al usuario
	 */
	public void menu() {
		//creamos la instancia para pedir los datos
		VMenuCrudPSin datos=new VMenuCrudPSin(gestor);
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
	
	public static void main(String[] args) {
		//Declaramos el arrayList, vector...
		List<Paciente> listPaciente=new ArrayList<Paciente>();
		//Declaramos el gestor
		GestorCrudPSin gestor=new GestorCrudPSin(listPaciente);
		//Lanzar aplicacion
		VMenuPrincipalPSin principal=new VMenuPrincipalPSin(gestor);
		principal.menu();
	}

}
