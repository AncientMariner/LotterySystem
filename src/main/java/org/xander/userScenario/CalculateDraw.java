package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Draw;
import org.xander.randomService.RandomNumberGenerationService;
import org.xander.randomService.RandomService;
import org.xander.service.DrawService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
public class CalculateDraw {
    @Qualifier("drawService")
    @Autowired
    private DrawService drawService;

    @Autowired
    private RandomService randomService;

    public CalculateDraw(DrawService drawService, RandomService randomService) {
        this.drawService = drawService;
        this.randomService = randomService;
    }

    public void generateDraw() {
        List<Integer> numbers = randomService.generateRandomNumber();

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        int sizeOfWinNumbers = ((RandomNumberGenerationService)randomService).getSizeOfWinNumbers();

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