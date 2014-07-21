package org.xander.randomService;

import com.mchange.v2.log.log4j.Log4jMLog;

import java.util.*;

public class RandomNumberGenerationService implements RandomService {

    private int sizeOfWinNumbers;

    public void setSizeOfWinNumbers(int sizeOfWinNumbers) {
        this.sizeOfWinNumbers = sizeOfWinNumbers;
    }

    public int getSizeOfWinNumbers() {
        return sizeOfWinNumbers;
    }

    public List<Integer> generateRandomNumber() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i < 51; i++) {
            numbers.add(i);

        }
        List<Integer> numbersList = new ArrayList<>(numbers);
        Collections.shuffle(numbersList);

        if (sizeOfWinNumbers > 25) {
            Log4jMLog.severe("Number of winner tickets is above 25, system could not guarantee their uniqueness, " +
                    "so decreasing the number to 15");
            sizeOfWinNumbers = 15;
        }

        return numbersList.subList(0, sizeOfWinNumbers);
    }
}
