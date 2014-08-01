package org.xander.userScenario;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Player;
import org.xander.service.PlayerService;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
                                   "classpath:/org/xander/model/applicationContext-dao.xml"})
public class PlayerGenerationTest {
    @Mock
    private PlayerHibernateDao playerHibernateDao;
    @Mock
    private Player player;
    private PlayerGeneration generatePlayer;

    @Before
    public void setUp() {
        initMocks(this);
        generatePlayer = new PlayerGeneration(new PlayerService(playerHibernateDao));
    }

    @Test
    public void generatePlayer() {
//        List<Draw> draws = new ArrayList<>();
//        draws.add(new Draw(1, 21));
//        draws.add(new Draw(2, 22));
//        draws.add(new Draw(3, 23));
//        draws.add(new Draw(4, 24));
//        draws.add(new Draw(5, 25));

        generatePlayer.generatePlayer("Jack-o-Lantern");

        verify(playerHibernateDao).saveOrUpdate((Player) anyObject());
    }

    @Test
    public void emptyConstructor() {
        generatePlayer = new PlayerGeneration();
        assertNotNull(generatePlayer);
    }

}
