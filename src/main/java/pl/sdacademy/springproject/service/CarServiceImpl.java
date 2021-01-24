package pl.sdacademy.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sdacademy.springproject.entity.CarAttributeEntity;
import pl.sdacademy.springproject.entity.CarEntity;
import pl.sdacademy.springproject.repository.CarRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarEntity> getCarsAsEntity(CarParameter carParameter) {
        List<CarEntity> foundCars = carRepository.findAll();
        return foundCars;
    }

    @Override
    public CarEntity createCar(CarParameter carParameter) {
        CarEntity ce = new CarEntity();
        ce.setColour(carParameter.getColour());
        ce.setProducer(carParameter.getProducer());
        ce.setModel(carParameter.getModel());

        //TODO  w zależności od regionu ustaw różną stawkę

        CarAttributeEntity cae = new CarAttributeEntity();
        //ce.setAttributes(cae);

        return carRepository.save(ce);
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
