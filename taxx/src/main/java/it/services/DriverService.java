package it.services;


import it.form.LoginForm;
import it.form.RegDriverForm;
import it.model.Driver;

import java.util.Optional;

public interface DriverService {
    String login(LoginForm loginForm);

    void register(RegDriverForm regDriverForm);

    boolean isExistByCookie(String cookieValue);

    Optional<Driver> findByEmail(String email);

    boolean checkReg(String email);

    int getSumForOrderForDay(long id);
}
