package org.xander.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Player;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
        "classpath:/org/xander/model/applicationContext-dao.xml"})
public class PlayerServiceTest {
    @Mock
    private PlayerHibernateDao playerHibernateDao;
    @Mock
    private Player player;
    private PlayerService playerService;


    @Before
    public void setUp() {
        initMocks(this);
        playerService = new PlayerService(playerHibernateDao);
    }

    @Test
    public void playerGetById() {
        when(playerHibernateDao.get(player.getId())).thenReturn(player);
        playerService.getById(player.getId());
        verify(playerHibernateDao).get(anyLong());
    }

    @Test
    public void playerGetAll() {
        playerService.getAll();
        verify(playerHibernateDao).getAll();
    }

    @Test
    public void createPlayer() {
        playerService.addContent(player);
        verify(playerHibernateDao).saveOrUpdate((Player) anyObject());
    }

    @Test
    public void getPlayerByPrize() {
        playerService.getByLotteryNumber(anyInt());
        verify(playerHibernateDao).getByLotteryNumber(anyInt());
    }

    @Test
    public void getPlayerByName() {
        playerService.getByName(anyString());
        verify(playerHibernateDao).getByName(anyString());
    }

    @Test
    public void emptyConstructor() {
        playerService = new PlayerService();
        assertNotNull(playerService);
    }

}
