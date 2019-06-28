package it.services;

import it.form.OrderForm;
import it.model.Driver;
import it.model.Order;
import it.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Component
@Lazy
@EnableTransactionManagement
public class ClientServiceImpl implements ClientService {
    @Autowired
    @Lazy
    @Qualifier(value = "orderRepositoryImpl")
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public void createNewOrder(OrderForm orderForm) {
        Driver driver = Driver.builder()
                .email("d@mail.ru")
                .firstname("d")
                .lastname("da")
                .phonenumber("44722236")
                .id(1L)
                .hashPassword("$2a$10$j5uhoNyC.Gn2Y13cPZOLIuAVwfRa01SxIrgu3lzKiDmboG1z0tbem")
                .build();
        Date date = new Date();
        Order order = Order.builder()
                .clientphone(orderForm.getClientPhone())
                .comment(orderForm.getComment())
                .firstaddress(orderForm.getFirstAddress())
                .lastaddress(orderForm.getLastAddress())
                .price(orderForm.getPrice())
                .driver(driver)
                .date(date)
                .build();
        orderRepository.newOrder(order);
    }
}
