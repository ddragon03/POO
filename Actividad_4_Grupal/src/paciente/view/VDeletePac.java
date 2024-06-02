package paciente.view;
import java.util.Scanner;

import common.model.IGestorCRUD;

public class VDeletePac {

	private Scanner sc;
	private IGestorCRUD gc;

	/**
	 * @param sc
	 * @param gc
	 */
	public VDeletePac(IGestorCRUD gc) {
		this.sc = new Scanner(System.in);
		this.gc = gc;
	}
	public boolean menu() {
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
