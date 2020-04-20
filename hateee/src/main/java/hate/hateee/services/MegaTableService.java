package hate.hateee.services;

import hate.hateee.mdls.RandomString;
import reactor.core.publisher.Flux;

public interface MegaTableService {

     Flux<RandomString> getAllRandom();
}
