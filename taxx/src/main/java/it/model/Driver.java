package it.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Driver {

    private Long id;

    private String firstName;

    private String lastName;
    private String hashPassword;

    private String rawPassword;

    private String email;

    private String phoneNumber;

    private String haveCar;
    private Car car;
    private List<Order> orders;
}
