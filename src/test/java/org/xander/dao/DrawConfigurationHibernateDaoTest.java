package org.xander.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.DrawConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = {"classpath:/org/xander/model/applicationContext-dao.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class DrawConfigurationHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private AbstractHibernateDao<DrawConfiguration> drawConfigurationHibernateDao;

    @Test
    public void getById() {
        DrawConfiguration drawConfiguration = new DrawConfiguration(1,2);
        drawConfigurationHibernateDao.saveOrUpdate(drawConfiguration);

        DrawConfiguration result = drawConfigurationHibernateDao.get(drawConfiguration.getId());
        assertEquals(drawConfiguration.getNumberOfWinners(), result.getNumberOfWinners());
        assertEquals(drawConfiguration.getPrize(), result.getPrize());
    }

    @Test
    public void getByPrizeSingle() {
        DrawConfiguration drawConfiguration = new DrawConfiguration(1,2);
        drawConfigurationHibernateDao.saveOrUpdate(drawConfiguration);

        List<DrawConfiguration> result = ((DrawConfigurationHibernateDao)drawConfigurationHibernateDao).getByPrize(drawConfiguration.getPrize());
        assertEquals(drawConfiguration.getNumberOfWinners(), result.get(0).getNumberOfWinners());
        assertEquals(drawConfiguration.getPrize(), result.get(0).getPrize());
    }

    @Test
    public void getByPrizeMultiple() {
        DrawConfiguration drawConfiguration1 = new DrawConfiguration(1,2);
        DrawConfiguration drawConfiguration2 = new DrawConfiguration(3,4);
        drawConfigurationHibernateDao.saveOrUpdate(drawConfiguration1);
        drawConfigurationHibernateDao.saveOrUpdate(drawConfiguration2);

        List<DrawConfiguration> result = ((DrawConfigurationHibernateDao)drawConfigurationHibernateDao).getByPrize(drawConfiguration2.getPrize());

        assertEquals(drawConfiguration2.getNumberOfWinners(), result.get(0).getNumberOfWinners());
        assertEquals(drawConfiguration2.getPrize(), result.get(0).getPrize());
    }

    @Test
    public void getAll() {
        DrawConfiguration drawConfiguration1 = new DrawConfiguration(1,2);
        DrawConfiguration drawConfiguration2 = new DrawConfiguration(3,4);
        drawConfigurationHibernateDao.saveOrUpdate(drawConfiguration1);
        drawConfigurationHibernateDao.saveOrUpdate(drawConfiguration2);

        List<DrawConfiguration> result = drawConfigurationHibernateDao.getAll();

        assertTrue(result.contains(drawConfiguration1));
        assertTrue(result.contains(drawConfiguration2));
    }
}
