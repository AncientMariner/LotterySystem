package org.xander.userScenario;

import org.xander.model.Draw;
import org.xander.model.Player;

import java.util.ArrayList;
import java.util.List;

public class OpenState implements PlayerGenerationState {
    PlayerGeneration playerGeneration;

    public OpenState(PlayerGeneration playerGeneration) {
        this.playerGeneration = playerGeneration;
    }

    @Override
    public void generatePlayer(String name) {
        List<Integer> numbers = new ArrayList<>();
        List<Draw> draws = playerGeneration.getDrawService().getAll();
        for (Draw draw : draws) {
            numbers.add(draw.getLotteryNumber());
        }

        Integer lotteryNumber = numbers.get(playerGeneration.getCountOfPlayers() - 1);
        Player player = new Player(name, lotteryNumber);
        playerGeneration.getPlayerService().addContent(player);

        playerGeneration.decreaseCountOfPlayersLeft();

        if (playerGeneration.getCountOfPlayers() == 0) {
            playerGeneration.setState(new ClosedState(playerGeneration));
        }
    }
}
