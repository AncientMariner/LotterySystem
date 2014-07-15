package org.xander.model;

public class Player implements Persistent {
    public static final String DEFAULT_NAME = "default name";
    public static final int DEFAULT_LOTTERY_NUMBER = 0;

    private Long id;
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

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setLotteryNumber(int lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }
}
