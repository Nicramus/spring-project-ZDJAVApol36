package pl.sdacademy.springproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.springproject.entity.CarEntity;
import pl.sdacademy.springproject.service.CarDto;
import pl.sdacademy.springproject.service.CarParameter;
import pl.sdacademy.springproject.service.CarService;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

//    println("1 - wyświetlenie wszystkich dostępnych samochodów");
//    println("2 - określenie warunków wyszukania a następnie wyświetlenie samochodów");
//    println("3 - wypożyczenie wybranego samochodu");
//    println("4 - zwrócenie wypożyczonego samochodu");
//    println("5 - zakończenie");


    @GetMapping(value = "/available-cars")
    //TODO paramsy
    public ResponseEntity<List<CarEntity>> getAllAvailableCarsByParameters() {
        CarParameter carParameter = CarParameter.builder().build();
        List<CarEntity> carsAsEntity = this.carService.getCarsAsEntity(carParameter);
        return ResponseEntity.ok().body(carsAsEntity);
    }

    //TODO create car with requestID (aby pokazać request scope)
    @PostMapping(value = "/create-car")
    public ResponseEntity<CarEntity> createCar(@RequestParam(name = "producer") final String producer) {
        CarParameter carParameter = CarParameter.builder().producer(producer).build();
        CarEntity car = this.carService.createCar(carParameter);
        return ResponseEntity.ok().body(car);
    }



    @GetMapping
    public String welcomeInfo() {
        return "here is info about app";
    }
}
