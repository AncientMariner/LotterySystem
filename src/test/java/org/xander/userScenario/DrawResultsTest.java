package org.xander.userScenario;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.xander.dao.DrawConfigurationHibernateDao;
import org.xander.dao.DrawHibernateDao;
import org.xander.dao.PlayerHibernateDao;
import org.xander.model.Draw;
import org.xander.model.Player;
import org.xander.randomService.RandomService;
import org.xander.service.DrawConfigurationService;
import org.xander.service.DrawService;
import org.xander.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DrawResultsTest {
    DrawResults drawResults;

    @Mock
    private DrawHibernateDao drawHibernateDao;
    @Mock
    private PlayerHibernateDao playerHibernateDao;
    @Mock
    private DrawConfigurationHibernateDao drawConfigurationHibernateDao;
    @Mock
    private Draw draw;
    @Mock
    private Player player;
    @Mock
    private RandomService randomService;

    private DrawService drawService;
    private DrawConfigurationService drawConfigurationService;

    private GeneratePlayer generatePlayer;
    private GenerateDraw generateDraw;
    private PlayerService playerService;

    @Before
    public void setUp() {
        initMocks(this);
        generateDraw = new GenerateDraw(new DrawService(drawHibernateDao), randomService);
        playerService = new PlayerService(playerHibernateDao);

        generatePlayer = new GeneratePlayer(playerService, randomService);
        drawResults = new DrawResults(playerService, drawService, drawConfigurationService);
    }

    @Test
    public void getNumberOfParticipatingPlayers() {
        drawResults.getPlayers();
        verify(playerHibernateDao).getAll();
    }

    @Test
    public void getNumberOfParticipatingTickets() {
        int ticketNumber = 1;
        List<Player> players = new ArrayList<>();
        players.add(player);

        when(playerService.getAll()).thenReturn(players);
        when(player.getLotteryNumber()).thenReturn(ticketNumber);

        List<Integer> tickets = drawResults.getTickets();
        verify(playerHibernateDao).getAll();
        assertTrue(tickets.contains(ticketNumber));
    }

    @Test
    public void getNumberOfWinners() {
        int ticketNumber = 1;
        List<Player> players = new ArrayList<>();
        players.add(player);

        when(playerService.getAll()).thenReturn(players);
        when(player.getLotteryNumber()).thenReturn(ticketNumber);
        List<Integer> tickets = drawResults.getTickets();
        Integer participatingTicketNumber = tickets.get(0);

        drawResults.getWinners();

        verify(drawConfigurationHibernateDao).getAll();
        verify(drawHibernateDao).getByPrize(anyInt());



    }
}
