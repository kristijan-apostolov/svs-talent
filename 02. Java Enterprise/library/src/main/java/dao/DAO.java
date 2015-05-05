package dao;

import java.util.List;

import entities.BaseEntity;

public interface DAO {

	@SuppressWarnings("rawtypes")
	List getAll();

	BaseEntity get(long id);

	void insert(BaseEntity entity);

	void update(BaseEntity entity);

	void delete(BaseEntity entity);
}
