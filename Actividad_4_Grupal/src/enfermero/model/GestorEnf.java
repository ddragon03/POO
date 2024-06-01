package enfermero.model;

import java.util.List;
import common.model.IGestorCrud;

public class GestorEnf implements IGestorCrud {
	private List<Enfermero> list;
	/**
	 * @param meds Element List
	 */
	public GestorEnf(List<Enfermero> list) {
		this.list = list;
	}
	/**
	 * agrega elementos
	 * @param med elemento
	 */
	public void create(Object elemento) {
		list.add((Enfermero)elemento);
	}
	/**
	 * @return devuelve la lista
	 */
	public List read() {
//		String sRet="";
//		for(int i=0;i<list.size();i++)
//			sRet+=i+". "+list.get(i)+"\r\n";
		return list;
	}
	/**
	 * actualiza
	 * @param pos posicion a actualizar (0..size-1)
	 * @param e elemento a actualizar
	 * @return verdadero si actualiza
	 */
	public boolean update(int pos, Object e) {
		boolean bRet=false;
		if (pos>=0 && pos<list.size()) {
			list.set(pos, (Enfermero)e);
			bRet=true;
		}
		return bRet;
	}
	/**
	 * borra
	 * @param pos
	 * @return verdadero si borra
	 */
	public boolean delete(int pos) {
		boolean bRet=false;
		if (pos>=0 && pos<list.size()) {
			list.remove(pos);
			bRet=true;
		}
		return bRet;
	}

}
