package org.xander.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.DrawHibernateDao;
import org.xander.model.Draw;
import org.xander.randomService.RandomService;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
                                   "classpath:/org/xander/model/applicationContext-dao.xml"})
public class DrawServiceTest {
    @Mock
    private DrawHibernateDao drawHibernateDao;
    @Mock
    private Draw draw;
    private DrawService drawService;
    @Mock
    private RandomService randomService;

    @Before
    public void setUp() {
        initMocks(this);
        drawService = new DrawService(drawHibernateDao);
    }

    @Test
    public void drawGetById() {
        when(drawHibernateDao.get(draw.getId())).thenReturn(draw);
        drawService.getById(draw.getId());
        verify(drawHibernateDao).get(anyLong());
    }

    @Test
    public void drawGetAll() {
        drawService.getAll();
        verify(drawHibernateDao).getAll();
    }

    @Test
    public void createDraw() {
        drawService.addContent(draw);
        verify(drawHibernateDao).saveOrUpdate((Draw) anyObject());
    }

    @Test
    public void getDrawByPrize() {
        drawService.getDrawByPrize(anyInt());
        verify(drawHibernateDao).getByPrize(anyInt());
    }
}
