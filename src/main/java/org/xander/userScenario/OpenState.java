package org.xander.userScenario;

import org.xander.model.Player;

public class OpenState implements PlayerGenerationState {
    PlayerGeneration playerGeneration;

    public OpenState(PlayerGeneration playerGeneration) {
        this.playerGeneration = playerGeneration;
    }

    @Override
    public void generatePlayer(String name, int number) {
        playerGeneration.getPlayerService().addContent(new Player(name, number));

        playerGeneration.decreaseCountOfPlayersLeft();
        if (playerGeneration.getCountOfPlayers() == 0) {
            playerGeneration.setState(new ClosedState(playerGeneration));
        }
    }
}
