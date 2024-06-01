package enfermero.view;

import java.util.List;
import java.util.Scanner;

import common.model.IGestorCrud;
import enfermero.model.Enfermero;


public class VReadEnf {

	
	private Scanner sc;
	private IGestorCrud gc;

	/**
	 * @param sc
	 * @param gc
	 */
	public VReadEnf(IGestorCrud gc) {
		this.sc = new Scanner(System.in);
		this.gc = gc;
	}
	
	public void menu() {
		List lRes=gc.read();
		String sRes="";
		if(lRes.size()==0)
			sRes="No hay datos";
		else {
			sRes="Los datos son:\r\n";
		}
		for(int i=0;i<lRes.size();i++) {
			String temp=((Enfermero) lRes.get(i)).toString();
			sRes+=temp+"\r\n";
		}
		System.out.println(sRes);
	}
}



