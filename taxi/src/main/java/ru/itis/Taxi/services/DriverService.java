package ru.itis.Taxi.services;

import ru.itis.Taxi.forms.LoginForm;
import ru.itis.Taxi.forms.RegDriverForm;
import ru.itis.Taxi.models.Driver;

public interface DriverService {
    void register(RegDriverForm regDriverForm);
    String login(LoginForm loginForm);
    boolean isExistByCookie(String cookieValue);
    int getSumForOrderForDay(int id);
}
