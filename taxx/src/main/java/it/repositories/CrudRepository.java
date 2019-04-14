package it.repositories;

import org.springframework.stereotype.Component;


public interface CrudRepository<T> {
    void save(T model);
}
