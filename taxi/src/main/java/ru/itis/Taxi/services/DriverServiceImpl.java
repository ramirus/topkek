package ru.itis.Taxi.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.Taxi.forms.LoginForm;
import ru.itis.Taxi.forms.RegDriverForm;
import ru.itis.Taxi.models.Auth;
import ru.itis.Taxi.models.Driver;
import ru.itis.Taxi.repositories.AuthRepository;
import ru.itis.Taxi.repositories.DriverRepository;

import java.util.UUID;

public class DriverServiceImpl implements DriverService {
    private DriverRepository driverRepository;
    private AuthRepository authRepository;
    private PasswordEncoder passwordEncoder;

    public DriverServiceImpl(DriverRepository driverRepository, AuthRepository authRepository) {
        this.driverRepository = driverRepository;
        this.authRepository = authRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void register(RegDriverForm regDriverForm) {
        Driver driver = Driver.builder()
                .firstName(regDriverForm.getFirstName())
                .lastName(regDriverForm.getLastName())
                .email(regDriverForm.getEmail())
                .phoneNumber(regDriverForm.getPhoneNumber())
                .hashPassword(passwordEncoder.encode(regDriverForm.getPassword()))
                .haveCar(regDriverForm.getHaveCar())
                .build();
        driverRepository.save(driver);
    }


    @Override
    public String login(LoginForm loginForm) {
        Driver driver = driverRepository.findOneByEmail(loginForm.getEmail());
        if (driver != null && passwordEncoder.matches(loginForm.getPassword(), driver.getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .driver(driver)
                    .cookieValue(cookieValue)
                    .build();
            authRepository.save(auth);
            return cookieValue;
        }
        return null;
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int getSumForOrderForDay(int id){
        return driverRepository.getSumForDay(id);
    }
}
