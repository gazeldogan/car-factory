package tr.com.vodafone.carfactory.service;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import tr.com.vodafone.carfactory.model.type.CarType;
import tr.com.vodafone.carfactory.service.impl.CarFactoryServiceImpl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CarFactoryServiceTest {

    @InjectMocks
    CarFactoryServiceImpl carFactoryService;

    @Test
    public void createCarFactoryForCabrio() {
        String result = carFactoryService.createCarFactory(CarType.CABRIO.name());
        assertEquals(result, "Cabrio Car has produced.");
    }

    @Test
    public void createCarFactoryForSedan() {
        String result = carFactoryService.createCarFactory(CarType.SEDAN.name());
        assertEquals(result, "Sedan Car has produced.");
    }

    @Test
    public void createCarFactoryForHatchback() {
        String result = carFactoryService.createCarFactory(CarType.HATCHBACK.name());
        assertEquals(result, "Hatchback Car has produced.");
    }

    @Test
    public void createCarFactoryExceptions() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carFactoryService.createCarFactory("BMV"));

    }

}
