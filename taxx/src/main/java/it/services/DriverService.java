package it.services;


import it.form.LoginForm;
import it.form.RegDriverForm;

public interface DriverService {
    String login(LoginForm loginForm);

    void register(RegDriverForm regDriverForm);

    boolean isExistByCookie(String cookieValue);

    boolean checkReg(String email);

    int getSumForOrderForDay(long id);
}
