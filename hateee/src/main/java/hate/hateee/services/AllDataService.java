package hate.hateee.services;

import hate.hateee.mdls.AllDTO;
import reactor.core.publisher.Flux;

public interface AllDataService {

    Flux<AllDTO> getAll();

}
