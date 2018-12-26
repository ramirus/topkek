package ru.itis.Taxi.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.Taxi.models.Driver;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverDto {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String haveCar;
    private String email;
    private String hashPassword;

    public static DriverDto from(Driver driver) {
        return DriverDto.builder()
                .id(driver.getId())
                .hashPassword(driver.getHashPassword())
                .phoneNumber(driver.getPhoneNumber())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .haveCar(driver.getHaveCar())
                .email(driver.getEmail())
                .build();
    }

    public static List<DriverDto> from(List<Driver> drivers) {
        return drivers.stream().map(DriverDto::from)
                .collect(Collectors.toList());
    }
}
