package org.xander.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.Dao;
import org.xander.model.Draw;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
                                   "classpath:/org/xander/model/applicationContext-dao.xml"})
public class DrawServiceTest {
    @Mock
    private Dao dao;
    @Mock
    Draw draw;
    private DrawService drawService;


    @Before
    public void setUp() {
        initMocks(this);
        drawService = new DrawService(dao);
    }

    @Test
    public void drawGetById() {
        when(dao.get(draw.getId())).thenReturn(draw);
        drawService.getById(draw.getId());
        verify(dao).get(anyLong());
    }

    @Test
    public void drawGetAll() {
        drawService.getAll();
        verify(dao).getAll();
    }

    @Test
    public void createDraw() {
        drawService.addContent(draw);
        verify(dao).saveOrUpdate(draw);
    }
}
