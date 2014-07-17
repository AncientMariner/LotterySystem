package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.xander.model.Player;
import org.xander.randomService.RandomService;
import org.xander.service.PlayerService;

public class GeneratePlayer {
    @Qualifier("playerService")
    @Autowired
    private PlayerService playerService;
    @Autowired
    private RandomService randomService;

    public GeneratePlayer(PlayerService playerService, RandomService randomService) {
        this.playerService = playerService;
        this.randomService = randomService;
    }

    public void generatePlayer(String name) {
        Player player = new Player(name, randomService.generateRandomNumber());
        playerService.addContent(player);
    }
}
