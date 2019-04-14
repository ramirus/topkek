package it.repositories;

import it.model.Auth;
import org.springframework.stereotype.Component;


public interface AuthRepository extends CrudRepository<Auth> {
    Auth findByCookieValue(String cookieValue);

}
