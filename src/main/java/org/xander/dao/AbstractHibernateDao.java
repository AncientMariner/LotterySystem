package org.xander.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xander.model.Persistent;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractHibernateDao<T extends Persistent> implements Dao<T> {
    private SessionFactory sessionFactory;

    /*be sure to name the method exactly of the returned entity type, not the getSessionFactory as IDE proposes !!!
    (spent 3 hours investigating the issue)*/
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private final Class<T> type = getType();

    public Class<T> getType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void saveOrUpdate(T player) {
        getSession().saveOrUpdate(player);
    }

    @Override
    public T get(Long id) {
        return (T) getSession().get(type, id);
    }
}
