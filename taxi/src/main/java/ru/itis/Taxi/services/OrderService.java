package ru.itis.Taxi.services;

import ru.itis.Taxi.forms.OrderForm;

public interface OrderService {
    void createNewOrder(OrderForm orderForm);
}
