package it.repositories;

import it.form.OrderForm;

public interface OrderRepository {
    void newOrder(OrderForm orderForm);
}
