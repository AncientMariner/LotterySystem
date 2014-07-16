package org.xander.randomService;

import java.util.Random;

public class RandomNumberGenerationService implements RandomService{

    public int generateRandomNumber() {
        Random random = new Random();
        int number = (int) (random.nextInt(50) + 1.5);
        if (number == 0) {
            number++;
        }
        return number;
    }
}
