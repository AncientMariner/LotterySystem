package org.xander.userScenario;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.model.DrawConfiguration;
import org.xander.service.DrawConfigurationService;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
                                   "classpath:/org/xander/model/applicationContext-dao.xml"})
public class SimpleGenerationTest {
    @Mock
    private DrawConfigurationService drawConfigurationService;
    private SimpleGeneration simpleGeneration;

    @Before
    public void setUp() {
        initMocks(this);
        simpleGeneration = new SimpleGeneration(drawConfigurationService);
    }

    @Test
    public void testGenerate() {
        verify(drawConfigurationService, times(3)).addContent((DrawConfiguration) anyObject());
    }

    @Test
    public void emptyConstructor() {
        simpleGeneration = new SimpleGeneration();
        assertNotNull(simpleGeneration);
    }

}
