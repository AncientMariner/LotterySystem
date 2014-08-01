package org.xander.randomService;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
        "classpath:/org/xander/model/applicationContext-dao.xml"})
public class RandomNumberGenerationServiceTest {
    @Test
    public void ensureGenerationDoesNotContainZero() {
        for (int i = 0; i < 500; i++) {
            generateRandom();
        }
    }

    @Test
    public void ensureGenerationDoesNotContainZeroAndDecreasingTheMaxWinnersNumber() {
        RandomService randomService = new RandomNumberGenerationService();
        ((RandomNumberGenerationService) randomService).setSizeOfWinNumbers(35);

        for (int i = 0; i < 500; i++) {
            generateRandomDecreasingTheWinners(randomService);
        }
    }

    public void generateRandom() {
        assertFalse(new RandomNumberGenerationService().generateRandomNumber().contains(0));
    }

    public void generateRandomDecreasingTheWinners(RandomService randomService) {
        assertFalse(randomService.generateRandomNumber().contains(0));
    }

    @Test
    public void getSizeOfWinNumbers() {
        RandomService randomService = new RandomNumberGenerationService();
        ((RandomNumberGenerationService)randomService).setSizeOfWinNumbers(6);

        assertEquals(6, ((RandomNumberGenerationService)randomService).getSizeOfWinNumbers());
    }
}
