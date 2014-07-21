package org.xander.userScenario;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Player;
import org.xander.randomService.RandomNumberGenerationService;
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
    private RandomNumberGenerationService randomService;
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
        List<Integer> numbers = new ArrayList<>();

        when(randomService.getSizeOfWinNumbers()).thenReturn(5);
        int sizeOfWinNumbers = randomService.getSizeOfWinNumbers();
        for (int i = 1; i <= sizeOfWinNumbers; i++) {
            numbers.add(i);
        }

        when(randomService.generateRandomNumber()).thenReturn(numbers);
        for (int i = 1; i <= sizeOfWinNumbers; i++) {
            playerGeneration.generatePlayer("Jack-o-Lantern" + i);
        }

        verify(randomService, times(sizeOfWinNumbers)).generateRandomNumber();
    }

    @Test
    public void generatePlayerNegative() {
        playerGeneration = new PlayerGeneration(new PlayerService(playerHibernateDao), randomService);
        List<Integer> numbers = new ArrayList<>();

        when(randomService.getSizeOfWinNumbers()).thenReturn(5);
        int sizeOfWinNumbers = randomService.getSizeOfWinNumbers();
        for (int i = 1; i <= sizeOfWinNumbers; i++) {
            numbers.add(i);
        }

        when(randomService.generateRandomNumber()).thenReturn(numbers);
        for (int i = 1; i <= sizeOfWinNumbers; i++) {
            playerGeneration.generatePlayer("Jack-o-Lantern" + i);
        }

        exception.expect(IllegalStateException.class);
        playerGeneration.generatePlayer("Jack-o-Lantern" + (sizeOfWinNumbers + 1));

        verify(randomService, times(sizeOfWinNumbers)).generateRandomNumber();
    }
}
