package hate.hateee.reps;

import hate.hateee.mdls.RandomString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MegaTableRep extends JpaRepository<RandomString, Long> {

    @Query(" select m from RandomString m")
    List<RandomString> getAll();

}
