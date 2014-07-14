package org.xander.dao;

import org.hibernate.Criteria;
import org.xander.model.Draw;

import java.util.List;

public class DrawHibernateDao extends AbstractHibernateDao<Draw>{
    @Override
    public List<Draw> getAll() {
        return getSession()
                .createCriteria(Draw.class)
                .list();
    }

    @Override
    public List<Draw> getByPrize(int prize) {
        return getSession()
                .createQuery("from Draw as P where P.prize = :prize")
                .setInteger("prize", prize)
                .list();
    }
}
