package org.xander.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DrawConfigurationTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    DrawConfiguration drawConfiguration;

    @Test
    public void basicDraw() {
        int prize = 10;
        int numberOfWinners = 1;
        drawConfiguration = new DrawConfiguration(prize, numberOfWinners);

        assertEquals(prize, drawConfiguration.getPrize());
        assertEquals(numberOfWinners, drawConfiguration.getNumberOfWinners());
    }

    @Test
    public void basicDrawNegativeNumber() {
        int prize = 10;
        int numberOfWinners = -1;

        exception.expect(IllegalStateException.class);
        drawConfiguration = new DrawConfiguration(prize, numberOfWinners);
    }

    @Test
    public void basicDrawNegativePrize() {
        int prize = -10;
        int numberOfWinners = 1;

        exception.expect(IllegalStateException.class);
        drawConfiguration = new DrawConfiguration(prize, numberOfWinners);
    }
}
