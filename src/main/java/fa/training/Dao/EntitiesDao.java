package fa.training.Dao;

import java.util.List;

public interface EntitiesDao<T> {
	
	public T getByID(int id);
	
	public List<T> getAll();
	
	public boolean update(T t);
	
	public boolean delete(int id);
	
	public boolean insertIntoDB(T t);
}
