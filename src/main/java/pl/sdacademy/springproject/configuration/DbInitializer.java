package pl.sdacademy.springproject.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.springproject.entity.CarAttributeEntity;
import pl.sdacademy.springproject.entity.CarEntity;
import pl.sdacademy.springproject.repository.CarRepository;
import pl.sdacademy.springproject.service.CarParameter;
import pl.sdacademy.springproject.service.CarService;

import java.math.BigDecimal;

@Component
public class DbInitializer implements CommandLineRunner {

    private final CarRepository carRepository;

    private final CarService carService;

    public DbInitializer(final CarRepository carRepository, final CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @Override
    public void run(final String... args) throws Exception {
        CarEntity ce = new CarEntity();
        ce.setColour("white");
        ce.setProducer("Porshe");
        ce.setModel("Panamera");
        //TODO ustawić price w zależności od regionu
        //ce.setPrice(new BigDecimal(300));
        CarAttributeEntity cae = new CarAttributeEntity();
        //ce.setAttributes(cae);

        carRepository.save(ce);

        CarParameter cp1 = CarParameter.builder().colour("white").model("Model S").producer("Tesla").build();
        CarEntity car1 = carService.createCar(cp1);

        CarParameter cp2 = CarParameter.builder().colour("black").model("Model S").producer("Tesla").build();
        CarEntity car2 = carService.createCar(cp2);


    }
}
