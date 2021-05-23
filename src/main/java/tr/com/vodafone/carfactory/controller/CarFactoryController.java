package tr.com.vodafone.carfactory.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.vodafone.carfactory.service.CarFactoryService;

@RestController
@RequestMapping("/api/car-factory")
@AllArgsConstructor
public class CarFactoryController {

    private final CarFactoryService carFactoryService;

    @GetMapping()
    public String createCarFactory(@RequestParam String carTypeName) {
        return carFactoryService.createCarFactory(carTypeName);
    }

}
