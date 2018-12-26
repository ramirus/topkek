package ru.itis.Taxi.models;

import lombok.*;


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
}
