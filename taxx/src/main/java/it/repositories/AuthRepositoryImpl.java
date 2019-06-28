package it.repositories;

import it.model.Auth;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Lazy
@Component
public class AuthRepositoryImpl implements AuthRepository {
    private JdbcTemplate jdbcTemplate;
    //language=SQL
    private static final String SQL_INSERT =
            "insert into auth(driverid, cookievalue) values (?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE_VALUE =
            "select * from auth where cookievalue = ?";

    public AuthRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Auth> authRowMapper = (rs, rowNum) -> Auth.builder()
            .id(rs.getLong("id"))
            .cookieValue(rs.getString("cookievalue"))
            .build();

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
        jdbcTemplate.update(SQL_INSERT, model.getDriverId(), model.getCookieValue());
    }
}
