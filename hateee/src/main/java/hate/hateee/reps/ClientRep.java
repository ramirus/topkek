package hate.hateee.reps;

import hate.hateee.mdls.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRep extends JpaRepository<Client,Long> {

    Client getClientById(Long id);
}
