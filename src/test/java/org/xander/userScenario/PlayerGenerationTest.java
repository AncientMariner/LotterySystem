package org.xander.userScenario;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Player;
import org.xander.randomService.RandomService;
import org.xander.service.PlayerService;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
        "classpath:/org/xander/model/applicationContext-dao.xml"})
public class PlayerGenerationTest {
    @Mock
    private PlayerHibernateDao playerHibernateDao;
    @Mock
    private Player player;
    @Mock
    private RandomService randomService;
    private PlayerGeneration generatePlayer;

    @Before
    public void setUp() {
        initMocks(this);
        generatePlayer = new PlayerGeneration(new PlayerService(playerHibernateDao), randomService);
    }

    @Test
    public void generatePlayer() {
        when(randomService.generateRandomNumber()).thenReturn(1);
        generatePlayer.generatePlayer("Jack-o-Lantern");

        verify(randomService).generateRandomNumber();
        verify(playerHibernateDao).saveOrUpdate((Player) anyObject());
    }
}
