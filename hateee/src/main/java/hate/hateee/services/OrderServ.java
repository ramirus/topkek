package hate.hateee.services;

import hate.hateee.mdls.Order;
import org.springframework.stereotype.Service;

public interface OrderServ {

    Order changeStatus(Long id, String status);
}
