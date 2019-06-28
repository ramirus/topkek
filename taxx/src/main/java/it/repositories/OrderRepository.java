package it.repositories;

import it.form.OrderForm;
import it.model.Order;

public interface OrderRepository {
    void newOrder(Order order);
}
