package hate.hateee.reps;

import hate.hateee.mdls.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface ItemsRep  extends JpaRepository<Items, Long> {

    @Query("from Items ")
    List<Items> getAll();
}
