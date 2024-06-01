package enfermero.model;

import java.util.List;

import common.model.IGestorCrud;
import common.util.FileUtil;

public class GestorFileEnf implements IGestorCrud {
	private List<Enfermero> list;
	private String path;
	/**
	 * Constructor
	 * @param list Element List
	 * @param path ruta al archivo de datos
	 */
	public GestorFileEnf(List<Enfermero> list,String path) {
		this.list=list;
		this.path=path;
	}
	/**
	 * agrega elementos
	 * @param med elemento
	 */
	public void create(Object elemento) {
		list.add((Enfermero)elemento);
		FileUtil fu=new FileUtil(path);
		fu.save(list);
	}
	/**
	 * @return devuelve la lista
	 */
	public List<Enfermero> read() {
		FileUtil fu=new FileUtil(path);
		list=fu.readList();
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
