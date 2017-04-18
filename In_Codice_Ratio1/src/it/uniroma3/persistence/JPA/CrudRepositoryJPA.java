package it.uniroma3.persistence.JPA;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.*;
import it.uniroma3.persistence.CrudRepository;

public class CrudRepositoryJPA<T> implements CrudRepository<T>{
	private EntityManager em;
	private Class<T> entityClass;
	
	public CrudRepositoryJPA(EntityManager em, Class<T> typeClass){
		this.em = em;
		this.entityClass = typeClass;		
	}
	
	@Override
	public T save(T entity){
		Method getId = null;
		T persistentEntity = null;
		try {
			getId = this.entityClass.getMethod("getId");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} try{
			if(getId.invoke(entity) == null){
				em.persist(entity);
				persistentEntity = entity;
			}else {
				persistentEntity = em.merge(entity);
			}
		}catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return persistentEntity;
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public List<T> findAll() {  
		String className = this.entityClass.getSimpleName();
		TypedQuery<T> query = em.createQuery("SELECT e FROM" +className+"e",this.entityClass); 
		return query.getResultList();
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
	}

	@Override
	public void deleteAll() {
		String className = this.entityClass.getSimpleName();
		Query query = em.createQuery("DELETE FROM "+ className);
		query.executeUpdate();
	}

	//getter e setter
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEm() {
		return em;
	}
	
}
