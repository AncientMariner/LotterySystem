package org.xander.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Draw;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"classpath:/org/xander/model/applicationContext-dao.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class DrawHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private Dao<Draw> drawHibernateDao;

    @Test
    public void getById() {
        Draw draw = new Draw(1, 2);
        drawHibernateDao.saveOrUpdate(draw);

        Draw result = drawHibernateDao.get(draw.getId());
        assertEquals(result.getLotteryNumber(), draw.getLotteryNumber());
        assertEquals(draw.getPrize(), result.getPrize());
    }

    @Test
    public void getByPrizeSingle() {
        Draw draw = new Draw(1, 2);
        drawHibernateDao.saveOrUpdate(draw);

        List<Draw> result = ((DrawHibernateDao)drawHibernateDao).getByPrize(draw.getPrize());
        assertEquals(draw.getLotteryNumber(), result.get(0).getLotteryNumber());
        assertEquals(draw.getPrize(), result.get(0).getPrize());
    }

    @Test
    public void getByPrizeMultiple() {
        Draw draw1 = new Draw(1, 2);
        Draw draw2 = new Draw(1, 3);
        drawHibernateDao.saveOrUpdate(draw1);
        drawHibernateDao.saveOrUpdate(draw2);

        List<Draw> result = ((DrawHibernateDao)drawHibernateDao).getByPrize(draw1.getPrize());

        assertEquals(draw1.getLotteryNumber(), result.get(0).getLotteryNumber());
        assertEquals(draw1.getPrize(), result.get(0).getPrize());
        assertEquals(draw2.getLotteryNumber(), result.get(1).getLotteryNumber());
        assertEquals(draw2.getPrize(), result.get(1).getPrize());
    }
}
