package org.xander.userScenario;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Draw;
import org.xander.model.Player;
import org.xander.service.DrawService;
import org.xander.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
                                   "classpath:/org/xander/model/applicationContext-dao.xml"})
public class GeneratePlayerStateTest {
    @Mock
    private PlayerHibernateDao playerHibernateDao;
    @Mock
    private Player player;
    @Mock
    private DrawService drawService;
    private PlayerGeneration playerGeneration;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void generatePlayer() {
        playerGeneration = new PlayerGeneration(new PlayerService(playerHibernateDao), drawService);
        List<Draw> draws = new ArrayList<>();
        draws.add(new Draw(1, 21));
        draws.add(new Draw(2, 22));
        draws.add(new Draw(3, 23));
        draws.add(new Draw(4, 24));
        draws.add(new Draw(5, 25));

        when(drawService.getAll()).thenReturn(draws);
        for (int i = 1; i <= draws.size(); i++) {
            playerGeneration.generatePlayer("Jack-o-Lantern" + i);
        }

        verify(drawService, times(5)).getAll();
    }

    @Test
    public void generatePlayerNegative() {
        playerGeneration = new PlayerGeneration(new PlayerService(playerHibernateDao), drawService);
        List<Draw> draws = new ArrayList<>();
        draws.add(new Draw(1, 21));
        draws.add(new Draw(2, 22));
        draws.add(new Draw(3, 23));
        draws.add(new Draw(4, 24));
        draws.add(new Draw(5, 25));

        when(drawService.getAll()).thenReturn(draws);
        for (int i = 1; i <= draws.size(); i++) {
            playerGeneration.generatePlayer("Jack-o-Lantern" + i);
        }

        verify(drawService, times(5)).getAll();

        exception.expect(IllegalStateException.class);
        playerGeneration.generatePlayer("Jack-o-Lantern" + (draws.size() + 1));
    }
}
