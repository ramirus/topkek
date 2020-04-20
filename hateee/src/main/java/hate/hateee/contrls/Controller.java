package hate.hateee.contrls;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hate.hateee.forms.Status;
import hate.hateee.mdls.Order;
import hate.hateee.reps.DriverRep;
import hate.hateee.reps.ItemsRep;
import hate.hateee.services.OrderServ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RepositoryRestController
public class Controller {
    private ObjectMapper mapper=new ObjectMapper();
    @Autowired
    private OrderServ orderServ;

    @Autowired
    private DriverRep driverRep;
    @Autowired
    private ItemsRep itemsRep;

    @RequestMapping(value = "/orders/{order_id}", method = RequestMethod.PUT)
    @ResponseBody
    public Order changeStatus(@PathVariable("order_id") Long orderId, @RequestBody Status status) throws JsonProcessingException {
        Order order=orderServ.changeStatus(orderId, status.getStatus());
        System.out.println(mapper.writeValueAsString(order));
        return order;

    }

}
