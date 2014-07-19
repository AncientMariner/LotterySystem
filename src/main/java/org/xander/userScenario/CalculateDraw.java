package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.Draw;
import org.xander.randomService.RandomService;
import org.xander.service.DrawService;

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
        int randomLotteryNumber1 = randomService.generateRandomNumber();
        int randomLotteryNumber2 = randomService.generateRandomNumber();
        int randomLotteryNumber3 = randomService.generateRandomNumber();
        int randomLotteryNumber4 = randomService.generateRandomNumber();
        int randomLotteryNumber5 = randomService.generateRandomNumber();
        // todo make sure number are different

        Draw randomDraw1 = new Draw(1000, randomLotteryNumber1);
        Draw randomDraw2 = new Draw(500, randomLotteryNumber2);
        Draw randomDraw3 = new Draw(100, randomLotteryNumber3);
        Draw randomDraw4 = new Draw(50, randomLotteryNumber4);
        Draw randomDraw5 = new Draw(20, randomLotteryNumber5);

        drawService.addContent(randomDraw1);
        drawService.addContent(randomDraw2);
        drawService.addContent(randomDraw3);
        drawService.addContent(randomDraw4);
        drawService.addContent(randomDraw5);
    }
}