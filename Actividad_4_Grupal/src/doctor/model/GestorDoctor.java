package doctor.model;

import java.util.List;
import common.model.IGestorCrud;
import doctor.model.Doctor;

public class GestorDoctor implements IGestorCrud{

	private List<Doctor> list;
	/**
	 * @param meds Element List
	 */
	public GestorDoctor(List<Doctor> list) {
		this.list = list;
	}
	/**
	 * agrega elementos
	 * @param med elemento
	 */
	public void create(Object elemento) {
		list.add((Doctor)elemento);
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
			list.set(pos, (Doctor)e);
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
