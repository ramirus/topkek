package hate.hateee.reps;

import hate.hateee.mdls.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface OrderRep extends JpaRepository<Order, Long> {
    @Query(value = "from Order ")
    List<Order> getAll();

    Order getOrderById(Long id);

}
