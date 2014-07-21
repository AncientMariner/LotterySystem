package org.xander.userScenario;

import org.xander.model.Player;
import org.xander.randomService.RandomService;

import java.util.List;

public class OpenState implements PlayerGenerationState {
    PlayerGeneration playerGeneration;

    public OpenState(PlayerGeneration playerGeneration) {
        this.playerGeneration = playerGeneration;
    }

    @Override
    public void generatePlayer(String name) {
        RandomService randomService = playerGeneration.getRandomService();
        List<Integer> numbers = randomService.generateRandomNumber();
        Integer lotteryNumber = numbers.get(playerGeneration.getCountOfPlayers() - 1);

        Player player = new Player(name, lotteryNumber);
        playerGeneration.getPlayerService().addContent(player);

        playerGeneration.decreaseCountOfPlayersLeft();

        if (playerGeneration.getCountOfPlayers() == 0) {
            playerGeneration.setState(new ClosedState(playerGeneration));
        }
    }
}
