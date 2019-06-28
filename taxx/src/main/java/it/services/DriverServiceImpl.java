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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;

@Lazy
@Component
@EnableTransactionManagement
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

    @Transactional
    @Override
    public String login(LoginForm loginForm) {
        Optional<Driver> driver = driverRepository.findOneByEmail(loginForm.getEmail());
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

    @Transactional
    @Override
    public void register(RegDriverForm regDriverForm) {
        Driver driver = Driver.builder()
                .firstname(regDriverForm.getFirstName())
                .lastname(regDriverForm.getLastName())
                .email(regDriverForm.getEmail())
                .phonenumber(regDriverForm.getPhoneNumber())
                .hashPassword(passwordEncoder.encode(regDriverForm.getPassword()))
                .haveCar(regDriverForm.getHaveCar())
                .build();
        driverRepository.save(driver);
    }

    @Transactional
    @Override
    public boolean isExistByCookie(String cookieValue) {
        return authRepository.findByCookieValue(cookieValue) != null;
    }

    @Transactional
    @Override
    public Optional<Driver> findByEmail(String email) {
        return driverRepository.findOneByEmail(email);
    }

    @Transactional
    @Override
    public boolean checkReg(String email) {
        return driverRepository.findOneByEmail(email).isPresent();
    }

    @Override
    public int getSumForOrderForDay(long id) {
        return driverRepository.getSumForDay(id);
    }
}
