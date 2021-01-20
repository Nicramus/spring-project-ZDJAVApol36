package pl.sdacademy.springproject.service;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Set;

@Getter
@Builder
@ToString
//@Component //TODO zrobić z tego bean
//TODO pozbyć się tego
public class CarParameter {
    private final String producer;
    private final String model;
    private final String colour;
    private final Set<String> attributes;
}

