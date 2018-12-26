package ru.itis.Taxi.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.Taxi.models.RatingComment;

import javax.sql.DataSource;
import java.util.List;

public class CommonRepositoryImpl implements CommonRepository {
    private static final String SQL_NEW_RAT_COM = "insert into rating(client_phone, count_rating, comment) values (?, ?, ?)";
    private static final String SQL_GET_ALL_RAT_COM = "select * from rating";
    private JdbcTemplate jdbcTemplate;
    private RowMapper<RatingComment> ratingRowMapper = (resultSet, i) -> RatingComment.builder()

            .id(resultSet.getLong("id"))
            .ratingCount(resultSet.getInt("count_rating"))
            .comment(resultSet.getString("comment"))
            .clientPhone(resultSet.getString("client_phone"))
            .build();

    public CommonRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void newRC(RatingComment ratingComment) {
        jdbcTemplate.update(SQL_NEW_RAT_COM, ratingComment.getClientPhone(), ratingComment.getRatingCount(), ratingComment.getComment());
    }

    @Override
    public List<RatingComment> getAllRC() {
        return jdbcTemplate.query(SQL_GET_ALL_RAT_COM, ratingRowMapper);
    }
}
