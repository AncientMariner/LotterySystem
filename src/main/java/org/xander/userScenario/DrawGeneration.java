package org.xander.userScenario;

import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Draw;
import org.xander.randomService.RandomNumberGenerationService;
import org.xander.randomService.RandomService;
import org.xander.service.DrawConfigurationService;
import org.xander.service.DrawService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
public class DrawGeneration {
    public DrawService drawService;
    public RandomService randomService;
    public DrawConfigurationService drawConfigurationService;
    public SimpleGeneration simpleGeneration;

    public DrawGeneration(DrawService drawService, RandomService randomService, SimpleGeneration simpleGeneration) {
        this.drawService = drawService;
        this.randomService = randomService;
        this.simpleGeneration = simpleGeneration;
    }

    public DrawGeneration() {
    }

    public void generate() {
        List<Integer> numbers = randomService.generateRandomNumber();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        int sizeOfWinNumbers = ((RandomNumberGenerationService) randomService).getSizeOfWinNumbers();

        if (uniqueNumbers.size() != sizeOfWinNumbers) {
            throw new UnsupportedOperationException("There is an error in random lottery service " +
                    "- please use your ticket for the next lottery draft");
        }

        for (int number = 1; number <= numbers.size(); number++) {
            addDraw(number);
        }
    }

    private void addDraw(int number) {
        Draw randomDraw = new Draw(number * 200, number);
        drawService.addContent(randomDraw);
    }
}