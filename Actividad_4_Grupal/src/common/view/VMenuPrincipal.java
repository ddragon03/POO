package common.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.model.IGestorCrud;
import common.util.FileUtil;
import doctor.model.Doctor;
import doctor.model.GestorDoctor;
import doctor.view.VMenuCrudMedico;
import enfermedad.model.GestorCrudFileEnfermGrave;
import enfermedad.model.Enfermedad;
import enfermedad.model.GestorCrudEnfermGrave;
import enfermedad.model.GestorCrudEnfermLeve;
import enfermedad.view.VMenuPrincipalEnfermGrave;
import enfermedad.view.VMenuPrincipalEnfermLeve;
import enfermero.model.Enfermero;
import enfermero.model.GestorEnf;
import enfermero.view.VMenuCrudEnf;
import medicamento.model.GestorCrudMed;
import medicamento.model.Medicamento;
import medicamento.view.VMenuPrincipalMed;
import paciente.model.GestorCrudPCon;
import paciente.model.PacienteCon;
import paciente.view.VMenuCrudPac;


/**
 * Muestra menu principal
 */
public class VMenuPrincipal {
	private Scanner sc;
	private final static String pathMed="data\\medicamento\\medicamento.dat";
	private final static String pathEnferm="data\\enfermedad\\enfermedad.dat";
	private final static String pathDoc="data\\doctor\\doctor.dat";
	private final static String pathEnf="data\\enfermero\\enfermero.dat";
	private final static String pathPac="data\\paciente\\paciente.dat";
	private IGestorCrud gestorMed;
	private IGestorCrud gestorSala;
	private IGestorCrud gestorDoc;
	private IGestorCrud gestorEnfer;
	private IGestorCrud gestorPac;
	/**
	 * @param gestorEnf 
	 * @param gestorDoctor 
	 * @param sc
	 * @return 
	 */
	public VMenuPrincipal(IGestorCrud igMed, IGestorCrud igSala, IGestorCrud gestorDoctor, IGestorCrud gestorEnf, IGestorCrud gestorPa) {
		gestorMed=igMed;
		gestorSala=igSala;
		gestorDoc=gestorDoctor;
		gestorEnfer=gestorEnf;
		gestorPac=gestorPa;
		this.sc = new Scanner(System.in);
	}
	/**
	 * Decide la opcion en funcion del menu
	 */
	public void menu() {
		//Lista de sintomas
		List<Enfermedad> listEnferm=new ArrayList<Enfermedad>();
		//Lista de medicamentos
		List<Medicamento> listMed=new ArrayList<Medicamento>();
		//Lista de doctores
		List<Doctor> listDoc=new ArrayList<Doctor>();
		//Lista de enfermeros
		List<Enfermero> listEnf=new ArrayList<Enfermero>();
		//Lista de pacientes
		List<PacienteCon> listPac=new ArrayList<PacienteCon>();
		//bucle para pedir datos
		//Declaramos el gestor
		GestorDoctor gestorD= new GestorDoctor(listDoc);
		GestorEnf gestorE=new GestorEnf(listEnf);
		GestorCrudPCon gestorP=new GestorCrudPCon(listPac);

		int opcion=menuOpcion();
		FileUtil fuMed=new FileUtil(this.pathMed);
		FileUtil fuEnferm=new FileUtil(this.pathEnferm);
		FileUtil fuDoc=new FileUtil(this.pathDoc);
		FileUtil fuEnf=new FileUtil(this.pathEnf);
		FileUtil fuPac=new FileUtil(this.pathPac);
		while(opcion!=0) {
			if (opcion==1) {
				//Declaramos el gestor
				GestorCrudEnfermLeve gestor=new GestorCrudEnfermLeve(listEnferm);
				//Lanzar aplicacion
				VMenuPrincipalEnfermLeve principal=new VMenuPrincipalEnfermLeve(gestor);
				principal.menu();
			}
			else if (opcion==2) {
				//Declaramos el gestor
				GestorCrudEnfermGrave gestor=new GestorCrudEnfermGrave(listEnferm);
				//Lanzar aplicacion
				VMenuPrincipalEnfermGrave principal=new VMenuPrincipalEnfermGrave(gestor);
				principal.menu();
			}else if (opcion==3) {
				//Declaramos el gestor
				GestorCrudMed gestor=new GestorCrudMed(listMed);
				//Lanzar aplicacion
				VMenuPrincipalMed principal=new VMenuPrincipalMed(gestor);
				principal.menu();
			}else if (opcion==4) {
				//Declaramos el gestor
				GestorDoctor gestor=new GestorDoctor(listDoc);
				//Lanzar aplicacion
				VMenuCrudMedico principal=new VMenuCrudMedico(gestor);
				principal.menu();
			}else if (opcion==5) {
				//Declaramos el gestor
				gestorE=new GestorEnf(listEnf);
				//Lanzar aplicacion
				VMenuCrudEnf principal=new VMenuCrudEnf(gestorD, gestorE);
				principal.menu();
			}else if (opcion==6) {
				//Declaramos el gestor
				gestorP=new GestorCrudPCon(listPac);
				//Lanzar aplicacion
				VMenuCrudPac principal=new VMenuCrudPac(gestorD, gestorP);
				principal.menu();
			}else if (opcion==7) {
				fuEnferm.save(listEnferm);
			}else if (opcion==8) {
				List<Enfermedad> listSinTmp=fuEnferm.readList();
				listEnferm=(listSinTmp!=null)?listSinTmp:listEnferm;
			}else if (opcion==9) {
				fuMed.save(listMed);
			}else if (opcion==10) {
				List<Medicamento> listMedTmp=fuMed.readList();
				listMed=(listMedTmp!=null)?listMedTmp:listMed;
			}else if (opcion==11) {
				fuDoc.save(listDoc);
			}else if (opcion==12) {
				List<Doctor> listDocTmp=fuDoc.readList();
				listDoc=(listDocTmp!=null)?listDocTmp:listDoc;
			}else if (opcion==13) {
				fuEnf.save(listEnf);
			}else if (opcion==14) {
				List<Enfermero> listEnfTmp=fuEnf.readList();
				listEnf=(listEnfTmp!=null)?listEnfTmp:listEnf;
			}else if (opcion==15) {
				fuPac.save(listPac);
			}else if (opcion==16) {
				List<PacienteCon> listPafTmp=fuPac.readList();
				listPac=(listPafTmp!=null)?listPafTmp:listPac;
			}
			opcion=menuOpcion();
		}
	} 

	/**
	 * menu principal de opciones
	 * @return entero introducido o -1 si hay error
	 */
	public int menuOpcion() {
		try {
			System.out.println("Introduce una opcion");
			System.out.println("1. Ir al CRUD de enfermedad leve");
			System.out.println("2. Ir al CRUD de enfermedad grave");
			System.out.println("3. Ir al CRUD de medicamentos");
			System.out.println("4. Ir al CRUD de doctores");
			System.out.println("5. Ir al CRUD de enfermeros");
			System.out.println("6. Ir al CRUD de pacientes");
			System.out.println("7. Guardar enfermedad a fichero");
			System.out.println("8. Cargar enfermedad de fichero");
			System.out.println("9. Guardar medicamentos a fichero");
			System.out.println("10. Cargar medicamentos de fichero");
			System.out.println("11. Guardar doctores a fichero");
			System.out.println("12. Cargar doctores de fichero");
			System.out.println("13. Guardar enfermeros a fichero");
			System.out.println("14. Cargar enfermeros de fichero");
			System.out.println("15. Guardar pacientes a fichero");
			System.out.println("16. Cargar pacientes de fichero");
			System.out.println("0. Para salir");
			return sc.nextInt();
		}catch (Exception e) {
			System.out.println("Opcion erronea");
			sc=new Scanner(System.in); //inicializamos
			return -1;
		}
	}

	public static void main(String[] args) {
		//Lista de medicamentos
		List<Medicamento> listMed=new ArrayList<Medicamento>();
		//Lista de sintomas
		List<Enfermedad> listSin=new ArrayList<Enfermedad>();
		//Lista de doctores
		List<Doctor> listDoc=new ArrayList<Doctor>();
		//Lista de enfermeros
		List<Enfermero> listEnf=new ArrayList<Enfermero>();
		//Lista de pacientes
		List<PacienteCon> listPac=new ArrayList<PacienteCon>();
		//llamamos al menu con los gestores de cada tipo de dato
		VMenuPrincipal principal=new VMenuPrincipal(
				new GestorCrudMed(listMed),new GestorCrudFileEnfermGrave(listSin,VMenuPrincipal.pathEnferm),new GestorDoctor(listDoc),new GestorEnf(listEnf),new GestorCrudPCon(listPac));
		principal.menu();
	}

}
