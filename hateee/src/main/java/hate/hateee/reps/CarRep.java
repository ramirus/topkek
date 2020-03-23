package hate.hateee.reps;

import hate.hateee.mdls.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRep extends JpaRepository<Car, Long> {
    @Query(value = "from Car")
    List<Car> getAll();

}
