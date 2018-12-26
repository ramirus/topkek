package ru.itis.Taxi.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.Taxi.forms.OrderForm;
import ru.itis.Taxi.models.Order;


import javax.sql.DataSource;

public class OrderRepositoryImpl implements OrderRepository {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_NEW_ORDER =
            "insert into orders(client_phone, first_address, last_address, price, comments, date) values (?, ?, ?, ?, ?, current_date )";

    public OrderRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Order> orderRowMapper = (resultSet, i) -> Order.builder()

            .id(resultSet.getLong("id"))
            .driverId(resultSet.getLong("driver_id"))
            .startPoint(resultSet.getString("first_address"))
            .endPoint(resultSet.getString("last_address"))
            .comment(resultSet.getString("comment"))
            .clientNumber(resultSet.getString("client_phone"))
            .price(resultSet.getInt("price"))
            .date(resultSet.getDate("date"))
            .build();

    @Override
    public void newOrder(OrderForm orderForm) {
        jdbcTemplate.update(SQL_NEW_ORDER,orderForm.getClientNumber(),orderForm.getStartPoint(),orderForm.getEndPoint(),orderForm.getPrice(),orderForm.getComment());
    }
}
