package it.repositories;

import it.model.Driver;

import java.util.Optional;


public interface DriverRepository extends CrudRepository<Driver> {
    Optional<Driver> findOneByEmail(String email);

    int getSumForDay(long id);

}
