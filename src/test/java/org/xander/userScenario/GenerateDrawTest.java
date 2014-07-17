package org.xander.userScenario;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.DrawHibernateDao;
import org.xander.model.Draw;
import org.xander.randomService.RandomService;
import org.xander.service.DrawService;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
        "classpath:/org/xander/model/applicationContext-dao.xml"})
public class GenerateDrawTest {
    @Mock
    private DrawHibernateDao drawHibernateDao;
    @Mock
    private Draw draw;
    @Mock
    private RandomService randomService;
    private GenerateDraw generateDraw;

    @Before
    public void setUp() {
        initMocks(this);
        generateDraw = new GenerateDraw(new DrawService(drawHibernateDao), randomService);
    }

    @Test
    public void generateDraw() {
        when(randomService.generateRandomNumber()).thenReturn(1);
        generateDraw.generateDraw();

        verify(randomService, times(5)).generateRandomNumber();
        verify(drawHibernateDao, times(5)).saveOrUpdate((Draw) anyObject());
    }
}
