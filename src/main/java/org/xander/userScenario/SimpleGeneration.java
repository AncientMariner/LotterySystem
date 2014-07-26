package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.xander.model.DrawConfiguration;
import org.xander.service.DrawConfigurationService;

@Transactional
public class SimpleGeneration {
    @Autowired
    public DrawConfigurationService drawConfigurationService;

    public SimpleGeneration() {
    }

    public SimpleGeneration(DrawConfigurationService drawConfigurationService) {
        this.drawConfigurationService = drawConfigurationService;
        generate();
    }

    private void generate() {
        drawConfigurationService.addContent(new DrawConfiguration(1000, 1));
        drawConfigurationService.addContent(new DrawConfiguration(500, 2));
        drawConfigurationService.addContent(new DrawConfiguration(100, 3));
    }
}
