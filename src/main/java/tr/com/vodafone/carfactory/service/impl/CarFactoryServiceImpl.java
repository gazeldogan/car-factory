package tr.com.vodafone.carfactory.service.impl;

import org.springframework.stereotype.Service;
import tr.com.vodafone.carfactory.model.Cabrio;
import tr.com.vodafone.carfactory.model.Car;
import tr.com.vodafone.carfactory.model.Hatchback;
import tr.com.vodafone.carfactory.model.Sedan;
import tr.com.vodafone.carfactory.model.type.CarType;
import tr.com.vodafone.carfactory.service.CarFactoryService;

@Service
public class CarFactoryServiceImpl implements CarFactoryService {

    public String createCarFactory(String carTypeName) {
        Car car = null;

        try {
            CarType carType = CarType.valueOf(carTypeName.toUpperCase());

            switch (carType) {
                case CABRIO: {
                    car = new Cabrio();
                    break;
                }
                case SEDAN: {
                    car = new Sedan();
                    break;
                }
                case HATCHBACK: {
                    car = new Hatchback();
                    break;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("CarTypeName invalid");
        }

        return car.getType();
    }
}
