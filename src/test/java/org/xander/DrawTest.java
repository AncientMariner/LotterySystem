package org.xander;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DrawTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    Draw draw;

    @Test
    public void generateDraw() {
        int number = 111;
        int prize = 1000;

        draw = new Draw(prize, number);

        assertEquals(number, draw.getLotteryNumber());
        assertEquals(prize, draw.getPrize());
    }

    @Test
    public void generateDrawNegativeNumber() {
        int number = -111;
        int prize = 1000;
        exception.expect(IllegalStateException.class);
        draw = new Draw(prize, number);
    }

    @Test
    public void generateDrawNegativePrize() {
        int number = 111;
        int prize = -1000;

        exception.expect(IllegalStateException.class);
        draw = new Draw(prize, number);
    }
}
