package it.services;

import it.form.LoginForm;
import it.form.RegDriverForm;
import it.model.Auth;
import it.model.Driver;
import it.repositories.AuthRepository;
import it.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Optional;
import java.util.UUID;

@Lazy
@Component
public class DriverServiceImpl implements DriverService {

    @Autowired
    @Lazy
    @Qualifier(value = "driverRepositoryImpl")
    private DriverRepository driverRepository;
    @Autowired
    @Lazy
    private AuthRepository authRepository;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginForm loginForm) {
        Optional<Driver> driver =  driverRepository.findOneByEmail(loginForm.getEmail());
        if (driver.isPresent() && passwordEncoder.matches(loginForm.getPassword(), driver.get().getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .driverId(driver.get().getId())
                    .cookieValue(cookieValue)
                    .build();
            authRepository.save(auth);
            return cookieValue;
        }
        return null;
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
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }
    @Override
    public Optional<Driver> findByEmail(String email){
        return driverRepository.findOneByEmail(email);
    }

    @Override
    public boolean checkReg(String email) {
        if (driverRepository.findOneByEmail(email).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public int getSumForOrderForDay(long id) {
        return driverRepository.getSumForDay(id);
    }
}
