package it.model;

import lombok.*;
import org.springframework.stereotype.Component;



@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    private String name;
    private String carNumber;
    private String color;
    private Long driverId;
}
