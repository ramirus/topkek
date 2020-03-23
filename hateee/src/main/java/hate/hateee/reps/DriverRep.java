package hate.hateee.reps;

import hate.hateee.mdls.Driver;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@RepositoryRestResource
public interface DriverRep extends JpaRepository<Driver, Long> {

    @RestResource(path = "drivers" , rel = "getAll")
    @Query(value = "from Driver ")
    List<Driver> getAll();

    @RestResource(path = "drivers/{id}", rel = "getDriverById")
    Driver getDriverById(Long id);
}
