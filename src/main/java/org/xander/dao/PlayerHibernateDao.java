package org.xander.dao;

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
                .createQuery("from Player as P where P.lotteryNumber = :lotteryNumber")
                .setInteger("lotteryNumber", lotteryNumber)
                .list();
    }
}
