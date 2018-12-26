package ru.itis.Taxi.repositories;

import ru.itis.Taxi.models.Auth;

public interface AuthRepository  extends CrudRepository<Auth>{
    Auth findByCookieValue(String cookieValue);
}
