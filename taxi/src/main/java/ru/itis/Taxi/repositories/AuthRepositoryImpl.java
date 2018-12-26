package ru.itis.Taxi.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.Taxi.models.Auth;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRepositoryImpl implements AuthRepository {
    private JdbcTemplate jdbcTemplate;
    //language=SQL
    private static final String SQL_INSERT =
            "insert into auth(driver_id, cookie_value) values (?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE_VALUE =
            "select * from auth where cookie_value = ?";

    public AuthRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Auth> authRowMapper = new RowMapper<Auth>() {
        @Override
        public Auth mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Auth.builder()
                    .id(rs.getLong("id"))
                    .cookieValue(rs.getString("cookie_value"))
                    .build();
        }
    };
    @Override
    public Auth findByCookieValue(String cookieValue) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE_VALUE, authRowMapper, cookieValue);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void save(Auth model) {
        jdbcTemplate.update(SQL_INSERT, model.getDriver().getId(), model.getCookieValue());
    }

    @Override
    public Auth find(Long id) {
        return null;
    }
}
