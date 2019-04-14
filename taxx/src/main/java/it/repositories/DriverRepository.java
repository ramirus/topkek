package it.repositories;

import it.model.Driver;


public interface DriverRepository extends CrudRepository<Driver> {
    Driver findOneByEmail(String email);

    int getSumForDay(long id);

}
