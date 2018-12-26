package ru.itis.Taxi.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RegDriverForm {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String haveCar;
}
