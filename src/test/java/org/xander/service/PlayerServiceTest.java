package org.xander.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.Dao;
import org.xander.model.Player;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
        "classpath:/org/xander/model/applicationContext-dao.xml"})
public class PlayerServiceTest {
    @Mock
    private Dao dao;
    @Mock
    Player player;
    private PlayerService playerService;


    @Before
    public void setUp() {
        initMocks(this);
        playerService = new PlayerService(dao);
    }

    @Test
    public void playerGetById() {
        when(dao.get(player.getId())).thenReturn(player);
        playerService.getById(player.getId());
        verify(dao).get(anyLong());
    }

    @Test
    public void playerGetAll() {
        playerService.getAll();
        verify(dao).getAll();
    }

    @Test
    public void createplayer() {
        playerService.addContent(player);
        verify(dao).saveOrUpdate(player);
    }
}
