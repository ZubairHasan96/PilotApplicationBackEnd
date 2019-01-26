package com.pilot.system.pilot.Repository.Generic;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

@Repository
public class GenericRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public T get(Integer id){
        return entityManager.find(getGenericTypeClass(),id);
    }

    public void save(T pilot) {
        entityManager.merge(pilot);
    }

    @SuppressWarnings("unchecked")
    private Class<T> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {
            throw new IllegalStateException("Class is not parametrized with generic type!!! Please use extends <> ");
        }
    }
}

