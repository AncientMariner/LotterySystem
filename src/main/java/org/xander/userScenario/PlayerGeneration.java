package org.xander.userScenario;

import org.springframework.transaction.annotation.Transactional;
import org.xander.randomService.RandomService;
import org.xander.service.PlayerService;

@Transactional
public class PlayerGeneration {
    private PlayerService playerService;
    private RandomService randomService;

    PlayerGenerationState state;
    private int countOfPlayers = 5;

    public PlayerGeneration(PlayerService playerService, RandomService randomService) {
        this.playerService = playerService;
        this.randomService = randomService;

        state = new OpenState(this);
    }

    public PlayerGeneration() {
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
