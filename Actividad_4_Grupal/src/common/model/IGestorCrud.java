package common.model;

import java.util.List;

public interface IGestorCrud {
	public void create(Object o);
	public List read();
	public boolean update(int pos, Object o);
	public boolean delete(int pos);

}
