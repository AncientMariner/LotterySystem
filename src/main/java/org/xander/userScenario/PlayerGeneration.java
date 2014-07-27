package org.xander.userScenario;

import org.springframework.transaction.annotation.Transactional;
import org.xander.service.PlayerService;

import java.util.Random;

@Transactional
public class PlayerGeneration {
    private PlayerService playerService;
    private PlayerGenerationState state;

    private int countOfPlayers = 5;
    public PlayerGeneration(PlayerService playerService) {
        this.playerService = playerService;

        state = new OpenState(this);
    }

    public PlayerGeneration() {
    }


    public static int randInt(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;

        return randomNumber;
    }

    public void generatePlayer(String name) {
        int numberOfLotteryBought = PlayerGeneration.randInt(1, 15);
        state.generatePlayer(name, numberOfLotteryBought);
    }

    void setState(PlayerGenerationState state) {
        this.state = state;
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
