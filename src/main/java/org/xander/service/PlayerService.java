package org.xander.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xander.dao.Dao;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Player;

import java.util.List;

@Service(value = "playerService")
@Transactional
public class PlayerService implements ContentService<Player> {
    Dao dao;

    public PlayerService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Player getById(Long id) {
        return (Player) dao.get(id);
    }

    @Override
    public void addContent(Player player) {
        dao.saveOrUpdate(player);
    }

    @Override
    public List<Player> getAll() {
        return dao.getAll();
    }

    public List<Player>getByLotteryNumber(int lotteryNumber) {
        return ((PlayerHibernateDao)dao).getByLotteryNumber(lotteryNumber);
    }
}
