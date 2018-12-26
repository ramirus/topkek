package ru.itis.Taxi.repositories;

import ru.itis.Taxi.forms.OrderForm;

public interface OrderRepository {
    void newOrder(OrderForm orderForm);
}
