package org.xander.userScenario;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.dao.DrawHibernateDao;
import org.xander.model.Draw;
import org.xander.model.DrawConfiguration;
import org.xander.randomService.RandomNumberGenerationService;
import org.xander.service.DrawConfigurationService;
import org.xander.service.DrawService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/service/applicationContext-service.xml",
                                   "classpath:/org/xander/model/applicationContext-dao.xml"})
public class DrawGenerationTest {
    @Mock
    private DrawHibernateDao drawHibernateDao;
    @Mock
    private Draw draw;
    @Mock
    private RandomNumberGenerationService randomService;
    @Mock
    private DrawConfigurationService drawConfigurationService;

    private DrawGeneration drawGeneration;
    private SimpleGeneration simpleGeneration;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        initMocks(this);
        simpleGeneration = new SimpleGeneration(drawConfigurationService);
        drawGeneration = new DrawGeneration(new DrawService(drawHibernateDao), randomService, simpleGeneration);
    }

    @Test
    public void generateDraw() {
        List<Integer> numbers = new ArrayList<>();

        when(randomService.getSizeOfWinNumbers()).thenReturn(5);
        int sizeOfWinNumbers = randomService.getSizeOfWinNumbers();
        for (int i = 1; i <= sizeOfWinNumbers; i++) {
            numbers.add(i);
        }

        when(randomService.generateRandomNumber()).thenReturn(numbers);

        drawGeneration.generate();

        verify(drawConfigurationService, times(3)).addContent((DrawConfiguration) anyObject());
        verify(randomService).generateRandomNumber();
        verify(drawHibernateDao, times(sizeOfWinNumbers)).saveOrUpdate((Draw) anyObject());
    }

    @Test
    public void generateDrawNegative() {
        List<Integer> numbers = new ArrayList<>();
        when(randomService.getSizeOfWinNumbers()).thenReturn(5);
        int sizeOfWinNumbers = randomService.getSizeOfWinNumbers();
        for (int i = 1; i <= sizeOfWinNumbers + 1; i++) {
            numbers.add(i);
        }

        when(randomService.generateRandomNumber()).thenReturn(numbers);

        exception.expect(UnsupportedOperationException.class);
        drawGeneration.generate();

        verify(randomService).generateRandomNumber();
        verify(drawHibernateDao, never()).saveOrUpdate((Draw) anyObject());
    }
}
