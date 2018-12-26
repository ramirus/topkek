package ru.itis.Taxi.repositories;

import ru.itis.Taxi.models.Driver;

public interface DriverRepository extends CrudRepository<Driver> {
    Driver findOneByEmail(String email);
    int getSumForDay(int id);
}
