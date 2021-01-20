package pl.sdacademy.springproject.service;

import pl.sdacademy.springproject.entity.CarAttributeEntity;
import pl.sdacademy.springproject.entity.CarEntity;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class CarMapper {

    public CarDto convert(CarEntity carEntity) {
        if (carEntity == null) {
            return CarDto.builder().build();
        }
        return CarDto.builder()
                .id(carEntity.getId())
                .producer(carEntity.getProducer())
                .model(carEntity.getModel())
                .colour(carEntity.getColour())
                // TODO: okreslic ile godzin wypozyczenia
                .price(carEntity.getPrice().multiply(BigDecimal.ONE))
                .attributes(carEntity.getAttributes().stream()
                        .map(CarAttributeEntity::getAttribute)
                        .collect(Collectors.toSet()))
                .build();
    }
}
