package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.xander.randomService.RandomService;
import org.xander.service.PlayerService;

@Transactional
public class PlayerGeneration {
    @Qualifier("playerService")
    @Autowired
    private PlayerService playerService;
    @Autowired
    private RandomService randomService;

    PlayerGenerationState state;
    private int countOfPlayers = 5;

    public PlayerGeneration(PlayerService playerService, RandomService randomService) {
        this.playerService = playerService;
        this.randomService = randomService;

        state = new OpenState(this);;
    }

    public void generatePlayer(String name) {
        state.generatePlayer(name);
    }

    void setState(PlayerGenerationState state) {
        this.state = state;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public RandomService getRandomService() {
        return randomService;
    }

    public int getCountOfPlayers() {
        return countOfPlayers;
    }

    public void decreaseCountOfPlayersLeft() {
        countOfPlayers--;
    }
}
