package org.xander.randomService;

import org.junit.Test;
import org.springframework.test.annotation.Repeat;

import static org.junit.Assert.assertTrue;

public class RandomServiceTest {
    @Test
    @Repeat(500)
    public void generateRandom() {
        RandomService randomService = new RandomNumberGenerationService();
        int randomNumber = randomService.generateRandomNumber();
        assertTrue(randomNumber != 0);
    }
}
