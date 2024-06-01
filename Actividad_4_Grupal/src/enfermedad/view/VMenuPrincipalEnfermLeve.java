package enfermedad.view;
import java.util.ArrayList;
import java.util.List;

import enfermedad.model.GestorCrudEnfermLeve;
import enfermedad.model.Enfermedad;

/**
 * Esta clase lanza la aplicacion
 */
public class VMenuPrincipalEnfermLeve {
	GestorCrudEnfermLeve gestor;
	public VMenuPrincipalEnfermLeve(GestorCrudEnfermLeve gestor) {
		this.gestor=gestor;
	}

	/**
	 * Muestra opciones CRUD al usuario
	 */
	public void menu() {
		//creamos la instancia para pedir los datos
		VMenuCrudEnfermLeve datos=new VMenuCrudEnfermLeve(gestor);
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
		GestorCrudEnfermLeve gestor=new GestorCrudEnfermLeve(list);
		//Lanzar aplicacion
		VMenuPrincipalEnfermLeve principal=new VMenuPrincipalEnfermLeve(gestor);
		principal.menu();
	}
}
