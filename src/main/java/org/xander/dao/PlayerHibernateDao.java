package org.xander.dao;

import org.hibernate.criterion.Restrictions;
import org.xander.model.Player;

import java.util.List;

public class PlayerHibernateDao extends AbstractHibernateDao<Player>{
    @Override
    public List<Player> getAll() {
        return getSession()
                .createCriteria(Player.class)
                .list();
    }

    public List<Player> getByLotteryNumber(int lotteryNumber) {
        return getSession()
                .createCriteria(Player.class)
                .add(Restrictions.eq("lotteryNumber", lotteryNumber))
                .list();
    }

    public Player getByName(String name) {
        return (Player) getSession()
                .createCriteria(Player.class)
                .add(Restrictions.eq("name", name)).uniqueResult();
    }
}
