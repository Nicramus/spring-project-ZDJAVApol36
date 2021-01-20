package pl.sdacademy.springproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.springproject.entity.CarEntity;
import pl.sdacademy.springproject.service.CarDto;
import pl.sdacademy.springproject.service.CarParameter;
import pl.sdacademy.springproject.service.CarService;

import java.util.List;

@RestController
//TODO main path
public class CarRentRestController {
    private CarService carService;

    public CarRentRestController(CarService carService) {
        this.carService = carService;
    }

//    println("1 - wyświetlenie wszystkich dostępnych samochodów");
//    println("2 - określenie warunków wyszukania a następnie wyświetlenie samochodów");
//    println("3 - wypożyczenie wybranego samochodu");
//    println("4 - zwrócenie wypożyczonego samochodu");
//    println("5 - zakończenie");


    @GetMapping(value = "/getavailablecars")
    //TODO paramsy
    public List<CarEntity> getAllAvailableCarsByParameters() {
        CarParameter carParameter = CarParameter.builder().build();
        return this.carService.getCarsAsEntity(carParameter);
    }

//    @PostMapping(value = "/createcar")
//    public CarDto createCar() {
//
//    }

    @GetMapping
    public String welcomeInfo() {
        return "here is info about app";
    }
}
