package enfermedad.model;
import java.util.List;

import common.model.IGestorCrud;
import common.util.FileUtil;

public class GestorCrudFileEnfermGrave implements IGestorCrud{
	private List<Enfermedad> list;
	private String path;
	/**
	 * Constructor
	 * @param list Element List 
	 * @param path
	 */
	public GestorCrudFileEnfermGrave(List<Enfermedad> list, String path) {
		this.list = list;	
		this.path = path;
	}
	/**
	 * agrega elementos
	 * @param 
	 */
	public void create(Object elemento) {
			list.add((EnfermedadGrave)elemento);
			FileUtil fu=new FileUtil(path);
			fu.save(list);
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
				list.set(pos, (EnfermedadGrave)e);
				bRet=true;
				FileUtil fu=new FileUtil(path);
				fu.save(list);
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
				FileUtil fu=new FileUtil(path);
				fu.save(list);
		}
		return bRet;
	}
	
}