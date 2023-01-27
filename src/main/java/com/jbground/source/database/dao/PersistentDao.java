package com.jbground.source.database.dao;

import java.util.List;

public interface PersistentDao {

    public void save(Object entity);
    public void delete(Object entity);
    public void update(Object entity);
    public Object find(Object entity);
    public Object findByName(Class clazz, Object entity);
    public Object findByName(Class clazz, String name);
    public List find(String sql);


}
