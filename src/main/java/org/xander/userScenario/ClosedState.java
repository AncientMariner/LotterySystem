package org.xander.userScenario;

public class ClosedState implements PlayerGenerationState {
    PlayerGeneration playerGeneration;

    public ClosedState(PlayerGeneration playerGeneration) {
        this.playerGeneration = playerGeneration;
    }

    @Override
    public void generatePlayer(String name, int number) {
        throw new IllegalStateException("Lottery is closed for purchases");
    }
}
