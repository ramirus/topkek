package ru.itis.Taxi.services;

import ru.itis.Taxi.forms.OrderForm;
import ru.itis.Taxi.repositories.OrderRepository;

public class OrderServiceImpl implements OrderService {
    private OrderRepository clientRepository;

    public OrderServiceImpl(OrderRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createNewOrder(OrderForm orderForm) {
        clientRepository.newOrder(orderForm);
    }
}
