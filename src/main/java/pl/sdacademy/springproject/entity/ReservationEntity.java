package pl.sdacademy.springproject.entity;

import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "reservation_start")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationStart;

    @Column(name = "reservation_end")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationEnd;

    @Column(name = "pesel")
    private String pesel;
}
