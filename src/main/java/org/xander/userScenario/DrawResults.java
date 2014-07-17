package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Player;
import org.xander.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class DrawResults {

    @Qualifier("playerService")
    @Autowired
    PlayerService playerService;

    public DrawResults(PlayerService playerService) {
        this.playerService = playerService;
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
}
