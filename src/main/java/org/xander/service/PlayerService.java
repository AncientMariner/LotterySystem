package org.xander.service;

import org.springframework.transaction.annotation.Transactional;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Player;

import java.util.List;

@Transactional
public class PlayerService implements ContentService<Player> {
    PlayerHibernateDao dao;

    public PlayerService(PlayerHibernateDao dao) {
        this.dao = dao;
    }

    public PlayerService() {
    }

    @Override
    public Player getById(Long id) {
        return dao.get(id);
    }

    @Override
    public void addContent(Player player) {
        dao.saveOrUpdate(player);
    }

    @Override
    public List<Player> getAll() {
        return dao.getAll();
    }

    public Player getByName(String name) {
        Player player = dao.getByName(name);
        return player;
    }

    public List<Player>getByLotteryNumber(int lotteryNumber) {
        return dao.getByLotteryNumber(lotteryNumber);
    }
}
