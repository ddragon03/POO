package medicamento.model;
import java.util.List;

import common.model.IGestorCrud;


public class GestorCrudMed implements IGestorCrud{
	private List<Medicamento> list;
	/**
	 * @param Element List de sintoma
	 */
	public GestorCrudMed(List<Medicamento> list) {
		this.list = list;	
	}
	/**
	 * agrega elementos
	 * @param 
	 */
	public void create(Object elemento) {
			list.add((Medicamento)elemento);
	}
	/**
	 * actualiza
	 * @return verdadero si actualiza
	 */
	public List read() {
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
				list.set(pos, (Medicamento)e);
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