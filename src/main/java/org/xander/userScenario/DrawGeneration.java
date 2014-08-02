package org.xander.userScenario;

import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Draw;
import org.xander.randomService.RandomNumberGenerationService;
import org.xander.randomService.RandomService;
import org.xander.service.DrawService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
public class DrawGeneration {
    public DrawService drawService;
    public RandomService randomService;
    public SimpleGeneration simpleGeneration;

    public DrawGeneration(DrawService drawService, RandomService randomService, SimpleGeneration simpleGeneration) {
        this.drawService = drawService;
        this.randomService = randomService;
        this.simpleGeneration = simpleGeneration;
    }

    public DrawGeneration() {
    }

    public void generate() {
        if (!isWinnersCombinationGenerated()) {
            throw new UnsupportedOperationException("Winners combination was not generated. System is down now. " +
                    "Please wait for the next draft");
        }

        List<Integer> numbers = randomService.generateRandomNumber();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        int sizeOfWinNumbers = ((RandomNumberGenerationService) randomService).getSizeOfWinNumbers();

        if (uniqueNumbers.size() != sizeOfWinNumbers) {
            throw new UnsupportedOperationException("There is an error in random lottery service " +
                    "- please use your ticket for the next lottery draft");
        }
        Draw randomDraw1 = new Draw(1000, numbers.get(0));
        drawService.addContent(randomDraw1);
        Draw randomDraw2 = new Draw(500, numbers.get(1));
        drawService.addContent(randomDraw2);
        Draw randomDraw3 = new Draw(500, numbers.get(2));
        drawService.addContent(randomDraw3);
        Draw randomDraw4 = new Draw(100, numbers.get(3));
        drawService.addContent(randomDraw4);
        Draw randomDraw5 = new Draw(100, numbers.get(4));
        drawService.addContent(randomDraw5);
    }

    public boolean isWinnersCombinationGenerated() {
        return simpleGeneration != null;
    }
}