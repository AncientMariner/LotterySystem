package org.xander.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.Dao;
import org.xander.model.DrawConfiguration;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
                                   "classpath:/org/xander/model/applicationContext-dao.xml"})
public class DrawConfigurationServiceTest {
    @Mock
    private Dao dao;
    @Mock
    DrawConfiguration drawConfiguration;
    private DrawConfigurationService drawConfigurationService;


    @Before
    public void setUp() {
        initMocks(this);
        drawConfigurationService = new DrawConfigurationService(dao);
    }

    @Test
    public void drawConfigurationGetById() {
        when(dao.get(drawConfiguration.getId())).thenReturn(drawConfiguration);
        drawConfigurationService.getById(drawConfiguration.getId());
        verify(dao).get(anyLong());
    }

    @Test
    public void drawConfigurationGetAll() {
        drawConfigurationService.getAll();
        verify(dao).getAll();
    }

    @Test
    public void createDrawConfiguration() {
        drawConfigurationService.addContent(drawConfiguration);
        verify(dao).saveOrUpdate(drawConfiguration);
    }
}
