package it.services;

import it.form.OrderForm;
import it.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ClientServiceImpl implements ClientService {
    @Autowired
    @Lazy
    @Qualifier(value = "orderRepositoryImpl")
    private OrderRepository orderRepository;

    @Override
    public void createNewOrder(OrderForm orderForm) {
        orderRepository.newOrder(orderForm);
    }
}
