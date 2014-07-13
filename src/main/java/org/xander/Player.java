package org.xander;

public class Player {
    public static final String DEFAULT_NAME = "default name";
    public static final int DEFAULT_LOTTERY_NUMBER = 0;

    private String name;
    private int lotteryNumber;

    public Player(String name, int lotteryNumber) {
        if (name == null || name.isEmpty()) {
            this.name = DEFAULT_NAME;
            this.lotteryNumber = DEFAULT_LOTTERY_NUMBER;
        } else if (lotteryNumber <= 0) {
            this.name = name;
        } else {
            this.name = name;
            this.lotteryNumber = lotteryNumber;
        }
    }

    public String getName() {
        return name;
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}
