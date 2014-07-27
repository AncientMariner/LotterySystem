package org.xander.userScenario;

import org.springframework.transaction.annotation.Transactional;
import org.xander.service.DrawService;
import org.xander.service.PlayerService;

@Transactional
public class PlayerGeneration {
    private PlayerService playerService;
    private DrawService drawService;

    private PlayerGenerationState state;

    private int countOfPlayers = 5;
    public PlayerGeneration(PlayerService playerService, DrawService drawService) {
        this.playerService = playerService;
        this.drawService = drawService;

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

    public DrawService getDrawService() {
        return drawService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public int getCountOfPlayers() {
        return countOfPlayers;
    }

    public void decreaseCountOfPlayersLeft() {
        countOfPlayers--;
    }
}
