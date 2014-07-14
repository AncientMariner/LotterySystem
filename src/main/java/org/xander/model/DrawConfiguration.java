package org.xander.model;

public class DrawConfiguration {
    private int prize;
    private int numberOfWinners;

    public DrawConfiguration(int prize, int numberOfWinners) {
        if (prize <= 0 || numberOfWinners <= 0) {
            throw new IllegalStateException("nor prize neither number Of Winners could be 0");
        }

        this.prize = prize;
        this.numberOfWinners = numberOfWinners;
    }

    public int getPrize() {
        return prize;
    }

    public int getNumberOfWinners() {
        return numberOfWinners;
    }
}
