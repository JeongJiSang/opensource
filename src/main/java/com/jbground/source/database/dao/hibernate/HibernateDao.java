package com.jbground.source.database.dao.hibernate;

import com.jbground.source.database.dao.PersistentDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class HibernateDao implements PersistentDao {

    SessionFactory sessionFactory;
    Session session;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Object entity) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public Object find(Object entity) {
        session = sessionFactory.getCurrentSession();
        return session.find(entity.getClass(), entity);
    }
    @Override
    public Object findByName(Class clazz, Object entity){
        session = sessionFactory.getCurrentSession();
        Object object = session.find(clazz, entity);
        session.close();
        return object;
    }
    @Override
    public Object findByName(Class clazz, String name){
        session = sessionFactory.getCurrentSession();
        Object object = session.find(clazz, name);
        session.close();
        return object;
    }

    @Override
    public List find(String sql) {
        session = sessionFactory.getCurrentSession();
        return null;
    }

}
