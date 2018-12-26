package ru.itis.Taxi.repositories;


import lombok.SneakyThrows;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.Taxi.models.Driver;
import ru.itis.Taxi.models.Order;

import javax.sql.DataSource;


public class DriverRepositoryJdbcImpl implements DriverRepository {

    private static final String SQL_INSERT_DRIVER =
            "insert into driver(email, hash_password, first_name, last_name, phone_number, have_car) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_EMAIL =
            "select * from driver where email = ?";
    private static final String SQL_SELECT_DRIVER_BY_ID = "select * from driver where id = ?";
    private static final String SQL_SELECT_SUM_FOR_DAY = "select sum(price) as sum from orders where current_date=orders.date and driver_id=?";

    private JdbcTemplate jdbcTemplate;

    public DriverRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Driver> driverRowMapper = (resultSet, i) -> Driver.builder()

            .id(resultSet.getLong("id"))
            .hashPassword(resultSet.getString("hash_password"))
            .phoneNumber(resultSet.getString("phone_number"))
            .email(resultSet.getString("email"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .haveCar(resultSet.getString("have_car"))
            .build();

    @SneakyThrows
    @Override
    public Driver findOneByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, driverRowMapper, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @SneakyThrows
    @Override
    public void save(Driver model) {
        jdbcTemplate.update(SQL_INSERT_DRIVER, model.getEmail(), model.getHashPassword(), model.getFirstName(), model.getLastName(), model.getPhoneNumber(), model.getHaveCar());

    }

    @SneakyThrows
    @Override
    public Driver find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_DRIVER_BY_ID,
                driverRowMapper, new Object[]{id});
    }

    @Override
    public int getSumForDay(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SUM_FOR_DAY, Integer.class);
    }
}
