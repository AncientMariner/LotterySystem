package org.xander;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;

    @Test
    public void name() {
        String expectedName = "John";
        player = new Player(expectedName, 0);
        assertEquals(expectedName, player.getName());
    }

    @Test
    public void nameNegative() {
        String nullName = null;
        player = new Player(nullName, 0);
        assertEquals("default name", player.getName());
    }

    @Test
    public void playerWithNumber() {
        String expectedName = "John";
        int lotteryNumber1 = 25;

        player = new Player(expectedName, lotteryNumber1);
        assertEquals(expectedName, player.getName());
        assertEquals(lotteryNumber1, player.getLotteryNumber());
    }

    @Test
    public void playerWithNegativeNameAndNumber() {
        String expectedName = null;
        int lotteryNumber = -2;

        player = new Player(expectedName, lotteryNumber);
        assertEquals("default name", player.getName());
        assertEquals(0, player.getLotteryNumber());
    }

    @Test
    public void playerWithNegativeNumber() {
        String expectedName = "John";
        int lotteryNumber = -2;

        player = new Player(expectedName, lotteryNumber);
        assertEquals(expectedName, player.getName());
        assertEquals(0, player.getLotteryNumber());
    }

    @Test
    public void playerWithEmptyNumber() {
        String expectedName = "John";

        player = new Player(expectedName, 0);
        assertEquals(expectedName, player.getName());
        assertEquals(0, player.getLotteryNumber());
    }
}
