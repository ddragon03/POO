package medicamento.view;
import java.util.ArrayList;
import java.util.List;

import medicamento.model.GestorCrudMed;
import medicamento.model.Medicamento;

/**
 * Esta clase lanza la aplicacion
 */
public class VMenuPrincipalMed {
	GestorCrudMed gestor;
	public VMenuPrincipalMed(GestorCrudMed gestor) {
		this.gestor=gestor;
	}

	/**
	 * Muestra opciones CRUD al usuario
	 */
	public void menu() {
		//creamos la instancia para pedir los datos
		VMenuCrudMed datos=new VMenuCrudMed(gestor);
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
