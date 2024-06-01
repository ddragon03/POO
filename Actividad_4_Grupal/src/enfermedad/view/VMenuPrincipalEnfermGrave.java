package enfermedad.view;
import java.util.ArrayList;
import java.util.List;

import enfermedad.model.GestorCrudEnfermGrave;
import enfermedad.model.Enfermedad;


/**
 * Esta clase lanza la aplicacion
 */
public class VMenuPrincipalEnfermGrave {
	GestorCrudEnfermGrave gestor;
	public VMenuPrincipalEnfermGrave(GestorCrudEnfermGrave gestor) {
		this.gestor=gestor;
	}

	/**
	 * Muestra opciones CRUD al usuario
	 */
	public void menu() {
		//creamos la instancia para pedir los datos
		VMenuCrudEnfermGrave datos=new VMenuCrudEnfermGrave(gestor);
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
		List<Enfermedad> list=new ArrayList<Enfermedad>();
		//Declaramos el gestor
		GestorCrudEnfermGrave gestor=new GestorCrudEnfermGrave(list);
		//Lanzar aplicacion
		VMenuPrincipalEnfermGrave principal=new VMenuPrincipalEnfermGrave(gestor);
		principal.menu();
	}
}
