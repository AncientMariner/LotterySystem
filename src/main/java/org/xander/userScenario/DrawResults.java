package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.DrawConfiguration;
import org.xander.model.Player;
import org.xander.service.DrawConfigurationService;
import org.xander.service.DrawService;
import org.xander.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class DrawResults {
    @Qualifier("playerService")
    @Autowired
    PlayerService playerService;
    @Qualifier("drawService")
    @Autowired
    DrawService drawService;
    @Qualifier("drawConfigurationService")
    @Autowired
    DrawConfigurationService drawConfigurationService;

    public DrawResults(PlayerService playerService,
                       DrawService drawService,
                       DrawConfigurationService drawConfigurationService) {
        this.playerService = playerService;
        this.drawService = drawService;
        this.drawConfigurationService = drawConfigurationService;
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

    public void getWinners() {
        List<DrawConfiguration> drawConfigurations = drawConfigurationService.getAll();
        for (DrawConfiguration drawConfiguration : drawConfigurations) {
            drawService.getDrawByPrize(drawConfiguration.getPrize());
        }



//        drawService.getDrawByPrize()
//        playerService.getByLotteryNumber()
    }
}
