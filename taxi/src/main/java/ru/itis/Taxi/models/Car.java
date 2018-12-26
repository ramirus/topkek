package ru.itis.Taxi.models;

import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Long id;
    private String brandOfMachine;
    private String carNumber;
    private String color;
}
