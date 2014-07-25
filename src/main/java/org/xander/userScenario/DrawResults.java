package org.xander.userScenario;

import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Draw;
import org.xander.model.DrawConfiguration;
import org.xander.model.Player;
import org.xander.service.DrawConfigurationService;
import org.xander.service.DrawService;
import org.xander.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class DrawResults {
    PlayerService playerService;
    DrawService drawService;
    DrawConfigurationService drawConfigurationService;

    public DrawResults(PlayerService playerService,
                       DrawService drawService,
                       DrawConfigurationService drawConfigurationService) {
        this.playerService = playerService;
        this.drawService = drawService;
        this.drawConfigurationService = drawConfigurationService;
    }

    public DrawResults() {
    }

    public List<Player> getPlayers() {
        return playerService.getAll();
    }

    public List<Integer> getTickets() {
        List<Integer> tickets = new ArrayList<>();

        for (Player player : playerService.getAll()) {
            tickets.add(player.getLotteryNumber());
        }
        return tickets;
    }

    public List<Player> getWinners() {
        List<Player> winnersList = new ArrayList<>();

        for (DrawConfiguration drawConfWinners : drawConfigurationService.getAll()) {
            List<Draw> drawList = drawService.getDrawByPrize(drawConfWinners.getPrize());
            for (Draw draw : drawList) {
                List<Player> playerList = playerService.getByLotteryNumber(draw.getLotteryNumber());
                winnersList.addAll(playerList);
            }
        }
        return winnersList;
    }
}
