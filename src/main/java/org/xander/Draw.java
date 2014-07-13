package org.xander;

public class Draw {
    private int prize;
    private int lotteryNumber;

    public Draw(int prize, int lotteryNumber) {
        if (prize <= 0 || lotteryNumber <= 0) {
            throw new IllegalStateException("nor prize neither lottery number could be 0");
        }
        this.prize = prize;
        this.lotteryNumber = lotteryNumber;
    }

    public int getPrize() {
        return prize;
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}
