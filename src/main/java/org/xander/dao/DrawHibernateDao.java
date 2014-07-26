package org.xander.dao;

import org.hibernate.criterion.Restrictions;
import org.xander.model.Draw;

import java.util.List;

public class DrawHibernateDao extends AbstractHibernateDao<Draw>{
    @Override
    public List<Draw> getAll() {
        return getSession()
                .createCriteria(Draw.class)
                .list();
        //                .createCriteria(Draw.class).setProjection(Projections.projectionList())
    }

    public List<Draw> getByPrize(int prize) {
        return getSession()
                .createCriteria(Draw.class)
                .add(Restrictions.eq("prize", prize))
                .list();
    }
}
