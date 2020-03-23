package hate.hateee.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import hate.hateee.mdls.Driver;
import hate.hateee.mdls.Order;
import hate.hateee.reps.OrderRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OrderServImpl implements OrderServ {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private OrderRep orderRep;

    @Override
    public Order changeStatus(Long id, String status) {
        Order order = orderRep.getOrderById(id);
        order.setStatus(status);
        orderRep.save(order);
        return order;
    }
}
