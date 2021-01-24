package pl.sdacademy.springproject.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Car")
public class CarEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String producer;
    private String model;
    private String colour;
    private BigDecimal price;
    private Byte automatic;
    private String vin;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Car_to_attribute",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "attr_id"))
    private Set<CarAttributeEntity> attributes = new HashSet<>();
}


