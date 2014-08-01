package org.xander.model;

public class DrawConfiguration implements Persistent{
    private Long id;
    private int prize;
    private int numberOfWinners;

    public DrawConfiguration(int prize, int numberOfWinners) {
        if (prize <= 0 || numberOfWinners <= 0) {
            throw new IllegalStateException("nor prize neither number Of winners could be 0");
        }
        this.prize = prize;
        this.numberOfWinners = numberOfWinners;
    }

    public DrawConfiguration() {
    }

    public int getPrize() {
        return prize;
    }

    public int getNumberOfWinners() {
        return numberOfWinners;
    }

    public Long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setPrize(int prize) {
        this.prize = prize;
    }

    private void setNumberOfWinners(int numberOfWinners) {
        this.numberOfWinners = numberOfWinners;
    }
}
