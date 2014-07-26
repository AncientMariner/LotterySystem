package org.xander.model;

public class Draw implements Persistent {
    private long id;
    private int prize;
    private int lotteryNumber;

    public Draw(int prize, int lotteryNumber) {
        if (prize <= 0 || lotteryNumber <= 0) {
            throw new IllegalStateException("nor prize neither lottery number could be 0");
        }
        this.prize = prize;
        this.lotteryNumber = lotteryNumber;
    }

    public Draw() {
    }

    public int getPrize() {
        return prize;
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setLotteryNumber(int lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    private void setPrize(int prize) {
        this.prize = prize;
    }
}
