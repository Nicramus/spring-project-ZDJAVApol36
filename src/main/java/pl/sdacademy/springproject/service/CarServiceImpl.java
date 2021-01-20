package pl.sdacademy.springproject.service;

import org.springframework.stereotype.Component;
import pl.sdacademy.springproject.entity.CarAttributeEntity;
import pl.sdacademy.springproject.entity.CarEntity;
import pl.sdacademy.springproject.repository.CarRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @PostConstruct
    private void postConstruct() {
        CarEntity ce = new CarEntity();
        ce.setColour("white");
        ce.setProducer("Porshe");
        ce.setModel("Panamera");
        CarAttributeEntity cae = new CarAttributeEntity();
        //ce.setAttributes(cae);
        carRepository.save(ce);

        List<CarEntity> foundCars = carRepository.findAll();
        System.out.println(foundCars);
    }

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarEntity> getCarsAsEntity(CarParameter carParameter) {
        List<CarEntity> foundCars = carRepository.findAll();
        return foundCars;

    }

//    @Override
//    public List<CarDto> getCars(CarParameter carParameter) {
//        List<CarEntity> foundCars = carRepository.findCarsByProducer(carParameter);
//
//        return foundCars.stream()
//                .map(entity -> carMapper.convert(entity))
//                .collect(Collectors.toList());
//    }
}
