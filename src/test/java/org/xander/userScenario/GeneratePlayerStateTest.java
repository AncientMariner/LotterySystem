package org.xander.userScenario;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Player;
import org.xander.randomService.RandomService;
import org.xander.service.PlayerService;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
        "classpath:/org/xander/model/applicationContext-dao.xml"})
public class GeneratePlayerStateTest {
    @Mock
    private PlayerHibernateDao playerHibernateDao;
    @Mock
    private Player player;
    @Mock
    private RandomService randomService;
    private PlayerGeneration playerGeneration;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void generatePlayer() {
        playerGeneration = new PlayerGeneration(new PlayerService(playerHibernateDao), randomService);
        when(randomService.generateRandomNumber()).thenReturn(1);
        playerGeneration.generatePlayer("Jack-o-Lantern1");
        playerGeneration.generatePlayer("Jack-o-Lantern2");
        playerGeneration.generatePlayer("Jack-o-Lantern3");
        playerGeneration.generatePlayer("Jack-o-Lantern4");
        playerGeneration.generatePlayer("Jack-o-Lantern5");
        exception.expect(IllegalStateException.class);
        playerGeneration.generatePlayer("Jack-o-Lantern6");
    }
}
