package org.xander.dao;

import org.hibernate.criterion.Restrictions;
import org.xander.model.DrawConfiguration;

import java.util.List;

public class DrawConfigurationHibernateDao extends AbstractHibernateDao<DrawConfiguration>{
    @Override
    public List<DrawConfiguration> getAll() {
        return getSession()
                .createCriteria(DrawConfiguration.class)
                .list();
    }

    public List<DrawConfiguration> getByPrize(int prize) {
        return getSession()
                .createCriteria(DrawConfiguration.class)
                .add(Restrictions.eq("prize", prize))
                .list();
//        raw sql way
//        return getSession()
//                .createQuery("from DrawConfiguration as P where P.prize = :prize")
//                .setInteger("prize", prize)
//                .list();
    }
}
