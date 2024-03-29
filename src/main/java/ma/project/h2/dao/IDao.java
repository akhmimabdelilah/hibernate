package ma.project.h2.dao;

import java.util.List;

public interface IDao<T> {

	T create(T o);

	boolean delete(T o);

	T update(T o);

	List<T> findAll();


}
