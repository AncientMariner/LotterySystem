package org.xander.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Player;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"classpath:/org/xander/model/applicationContext-dao.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PlayerDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private PlayerHibernateDao playerHibernateDao;

    @Test
    public void getById() {
        Player player = new Player("player", 1234);
        playerHibernateDao.saveOrUpdate(player);

        Player result = playerHibernateDao.get(player.getId());
        assertEquals(player.getLotteryNumber(), result.getLotteryNumber());
        assertEquals(player.getName(), result.getName());
    }

    @Test
    public void getByPrizeSingle() {
        Player player = new Player("player", 1234);
        playerHibernateDao.saveOrUpdate(player);

        List<Player> result = playerHibernateDao.getByLotteryNumber(player.getLotteryNumber());
        assertEquals(player.getLotteryNumber(), result.get(0).getLotteryNumber());
        assertEquals(player.getName(), result.get(0).getName());
    }

    @Test
    public void getByPrizeMultiple() {
        Player player1 = new Player("player1", 1234);
        Player player2 = new Player("player2", 12345);
        playerHibernateDao.saveOrUpdate(player1);
        playerHibernateDao.saveOrUpdate(player2);

        List<Player> result = playerHibernateDao.getByLotteryNumber(player1.getLotteryNumber());

        assertEquals(player1.getLotteryNumber(), result.get(0).getLotteryNumber());
        assertEquals(player1.getName(), result.get(0).getName());
    }
}
