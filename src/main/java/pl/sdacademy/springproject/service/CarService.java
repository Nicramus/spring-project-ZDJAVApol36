package pl.sdacademy.springproject.service;

import org.springframework.stereotype.Service;
import pl.sdacademy.springproject.entity.CarEntity;

import java.util.List;

public interface CarService {
    //List<CarDto> getCars(CarParameter carParameter);
    List<CarEntity> getCarsAsEntity(CarParameter carParameter);
    CarEntity createCar(CarParameter carParameter);
}
